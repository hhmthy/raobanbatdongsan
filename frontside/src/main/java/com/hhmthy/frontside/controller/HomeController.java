package com.hhmthy.frontside.controller;

import com.hhmthy.frontside.entity.DistrictEntity;
import com.hhmthy.frontside.entity.ProvinceEntity;
import com.hhmthy.frontside.entity.UserEntity;
import com.hhmthy.frontside.model.*;
import com.hhmthy.frontside.service.*;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.sql.Date;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
public class HomeController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ProvinceService provinceService;

    @Autowired
    private DistrictService districtService;

    @Autowired
    private UserService userService;

    @Autowired
    private PostCataService postCataService;

    @Autowired
    private FullPostService fullPostService;

    @Autowired
    private FavoriteService favoriteService;


    /**
     * ******* User controller *******
     */
    @PostMapping("/signin")
    public String signin(Model model, @Valid @ModelAttribute("signinForm") SigninForm signinForm, BindingResult bindingResult, HttpServletRequest request) {
        if (bindingResult.hasErrors()) {
            return "/signin";
        }

        SigninResponse signinResponse = new SigninResponse();

        List<UserEntity> users = userService.findByUsernameAndPassword(signinForm.getUsername(), signinForm.getPassword());
        if (Objects.nonNull(users) && users.size() > 0) {
            signinResponse.setSuccess(true);
            signinResponse.setToken("random-token");
        }

        if (signinResponse.isSuccess()) {
            long userId = userService.findByUsername(signinForm.getUsername()).get(0).getUserId();
            request.getSession().setAttribute("user_id", userId);
            request.getSession().setAttribute("username", signinForm.getUsername());
            return "redirect:/";
        }
        model.addAttribute("errorMessage", "Thông tin tài khoản không chính xác. Vui lòng kiểm tra lại!");
        return "/signin";
    }

    @GetMapping("/signin")
    public String signinPage(Model model) {
        model.addAttribute("signinForm", new SigninForm());
        return "/signin";
    }

    @GetMapping("/signup")
    public String signup(Model model, HttpSession httpSession) {
        if (httpSession.getAttribute("username") != null) {
            return "redirect:/";
        }
        model.addAttribute("signupForm", new SignupForm());
        model.addAttribute("genders", Arrays.asList("Nam", "Nữ"));
        return "/signup";
    }


    @PostMapping("/signup")
    public String signup(Model model, @Valid @ModelAttribute("signupForm") SignupForm signupForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/signup";
        }

        if (!StringUtils.equals(signupForm.getPassword(), signupForm.getRePassword())) {
            model.addAttribute("errorMessage", "Mật khẩu lặp lại chưa khớp");
            return "/signup";
        }
//        SignupResponse signupResponse = restTemplate.getForObject("http://authentication/user/signup", SignupResponse.class);
        // mock responese
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(signupForm.getUsername());
        userEntity.setPassword(signupForm.getPassword());
        userEntity.setGender(Byte.valueOf(
                (byte) ((signupForm.getGender() == "Nam") ? 1 : 0)
        ));
        userEntity.setAddress(signupForm.getAddress());
        userEntity.setEmail(signupForm.getEmail());
        userEntity.setPhone(signupForm.getPhoneNumber());
        userEntity.setRole_id(1);
        /*userEntity.setBirthday((Date) signupForm.getBirthday());*/
        userService.addUser(userEntity);
        SignupResponse signupResponse = new SignupResponse();
        signupResponse.setSuccess(true);

        if (signupResponse.isSuccess()) {
            return "redirect:/";
        }
        return "/signup";
    }

    @GetMapping("/logout")
    public String logout(Model model, HttpServletRequest request) {
        request.getSession().invalidate();
        return "redirect:/";
    }

    @GetMapping("/{userId}")
    public String viewUserInfo(Model model, @PathVariable("userId") int userId) {
        model.addAttribute("loginForm", new UserInfoForm());
        return "/index";
    }

    @GetMapping("/profile")
    public String profile(HttpServletRequest request, Model model) {
        String username = (String) request.getSession().getAttribute("username");
        UserEntity entityUserInfor = userService.findByUsername(username).get(0);
        model.addAttribute("UserInfor", entityUserInfor);
        return "profile";
    }

    @PostMapping("/forgetPassword")
    public String forgetPassword(Model model, @Valid @ModelAttribute("forgetPasswordForm") ForgetPasswordForm forgetPasswordForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/forget-password";
        }
//      ForgetPasswordResponse forgetPasswordResponse = restTemplate.getForObject("http://authentication/signin", ForgetPasswordResponse.class);
        // mock responese
        ForgetPasswordResponse forgetPasswordResponse = new ForgetPasswordResponse();
        forgetPasswordResponse.setSuccess(true);

        if (forgetPasswordResponse.isSuccess()) {
            return "redirect:/signin";
        }
        return "/forget-password";
    }

    @GetMapping("/forgetPassword")
    public String forgetPassword(Model model) {
        model.addAttribute("forgetPasswordForm", new ForgetPasswordForm());
        return "/forget-password";
    }

    /**
     * ******* Home controller *******
     */

    /**
     * Lấy list post id trong List URL
     *
     * @param list
     * @return List kiểu Long
     */
    private List<Long> getListPostIdByURL(List<PostCataModel> list) {
        List<Long> listId = new ArrayList<>();
        for (PostCataModel item :
                list) {
            String strURL = item.getLinks().get(0).getHref().trim();
            String valueOfURL = String.valueOf(strURL.charAt(strURL.length() - 1));
            listId.add(Long.parseLong(valueOfURL));
        }
        return listId;
    }

    public static <K, V> Map<K, V> zipToMap(List<K> keys, List<V> values) {
        Iterator<K> keyIter = keys.iterator();
        Iterator<V> valIter = values.iterator();
        return IntStream.range(0, keys.size()).boxed()
                .collect(Collectors.toMap(_i -> keyIter.next(), _i -> valIter.next()));
    }

    @GetMapping("/")
    public String home(Model model) {
        List<PostCataModel> listNewestPost = postCataService.getAllPostCata();
        List<PostCataModel> listFeaturePost = postCataService.getAllPostCata();
        Collections.shuffle(listNewestPost, new Random(System.nanoTime()));
        List<Long> postIdOfNewestListPost = getListPostIdByURL(listNewestPost);
        //Merge list post id and list data to Map(Newest Post)
        Map<Long, PostCataModel> listNewestFinal = zipToMap(postIdOfNewestListPost, listNewestPost);

        Collections.shuffle(listFeaturePost, new Random(System.nanoTime()));
        List<Long> postIdOfFeatureListPost = getListPostIdByURL(listFeaturePost);
        //Merge list post id and list data to Map(Feature Post)
        Map<Long, PostCataModel> listFeatureFinal = zipToMap(postIdOfFeatureListPost, listFeaturePost);

        model.addAttribute("provinces", getProvinces());
        model.addAttribute("districts", getDistricts());
        model.addAttribute("listNewestFinal", listNewestFinal);
        model.addAttribute("listFeatureFinal", listFeatureFinal);
        return "/index";
    }

    private List<ProvinceEntity> getProvinces() {
        Iterable<ProvinceEntity> provinceEntities = provinceService.findAll();
        List<ProvinceEntity> provinces = new ArrayList<ProvinceEntity>();
        for (ProvinceEntity str : provinceEntities) {
            provinces.add(str);
        }
        return provinces;
    }

    private List<DistrictEntity> getDistricts() {
        Iterable<DistrictEntity> districtEntities = districtService.findAll();
        List<DistrictEntity> districts = new ArrayList<DistrictEntity>();
        for (DistrictEntity str : districtEntities) {
            districts.add(str);
        }
        return districts;
    }

    @GetMapping(value = "/getDistrict/{provinceId}")
    public String getDistrict(Model model, @PathVariable("provinceId") Integer provinceId) {
        model.addAttribute("districts", districtService.findByProvinceId(provinceId));
        return "district-result :: district-result";
    }

    @GetMapping("/termsConditions")
    public String termConditions() {
        return "/terms-conditions";
    }

    @GetMapping("/contact")
    public String contact() {
        return "/contact";
    }

    @GetMapping("/about")
    public String aboutUs() {
        return "/about-us";
    }


    /**
     * ******* Property controller *******
     */

    @GetMapping("/submit-property")
    public String submitProperty(HttpSession httpSession, Model model) {
        if (httpSession.getAttribute("username") != null) {
            model.addAttribute("typeofcreate", new TypeCreatePostModel());
            return "submit-first-step";
        }
        return "redirect:/";
    }


    @PostMapping("/create-property")
    public String createProperty(@ModelAttribute("typeofcreate") TypeCreatePostModel typeCreatePostModel, HttpSession httpSession) {
        //check user login
        if (httpSession.getAttribute("username") != null) {
            //redirect to sale house page
            if ((typeCreatePostModel.getTypeOfPost() == 1) & (typeCreatePostModel.getTypeOfRe() == 1)) {

                return "redirect:/create-property-sale-house";
            }

            //redirect to sale land page
            if ((typeCreatePostModel.getTypeOfPost() == 1) & (typeCreatePostModel.getTypeOfRe() == 2)) {
                return "redirect:/createPropertySaleLand";
            }

            return "submit-first-step";
        }
        return "redirect:/";

    }

    @GetMapping("/create-property-sale-house")
    public String createPropertySaleHouse(Model model) {
        PostHouseModel objPostHouse = new PostHouseModel();
        List<ProvinceEntity> provinces = getProvinces();
        List<DistrictEntity> district = getDistricts();
        model.addAttribute("provinces", provinces);
        model.addAttribute("districts", district);
        model.addAttribute("objPostHouse", objPostHouse);
        return "create-property-sale-house";
    }

    @PostMapping("/proccessPostSaleHouse")
    public String proccessPostSaleHouse(@ModelAttribute("objPostHouse") PostHouseModel postHouseModel) {
        postHouseModel.setCity(provinceService.findOne(Integer.parseInt(postHouseModel.getCity())).get().getName());
        postHouseModel.setDistrict(districtService.findOne(Integer.parseInt(postHouseModel.getDistrict())).get().getName());
        fullPostService.addAFullPostSaleHouse(postHouseModel);

        return "post-successfully";
    }

    @GetMapping("/successfullyPostProperty")
    public String successfullyPostProperty() {
        return "post-successfully";
    }

    @GetMapping("/createPropertySaleLand")
    public String createPropertyLentLand() {
        return "create-property-sale-land";
    }

    @GetMapping("/manageMotel")
    public String manageMotel() {
        return "manage-motel";
    }

    @GetMapping("/createMotel")
    public String createMotel() {
        return "create-motel";
    }



    @GetMapping("/my-property")
    public String myProperty(HttpServletRequest request, Model model) {
        String username = (String) request.getSession().getAttribute("username");
        Long id = userService.findByUsername(username).get(0).getUserId();
        List<PostCataModel> list = postCataService.getAllPostCataByUserId(id);

        model.addAttribute("listPostCataByUserId", list);
        return "my-property";
    }

    @GetMapping("/property-listing-line")
    public String propertyListing(Model model) {
        List<PostCataModel> listPost = postCataService.getAllPostCata();

        List<Long> postIdOfNewestListPost = getListPostIdByURL(listPost);

        Map<Long, PostCataModel> listPostFinal = zipToMap(postIdOfNewestListPost, listPost);
        model.addAttribute("listPostFinal", listPostFinal);
        return "property-listing-line";
    }

    @GetMapping("/property-detail/{catalog}/{post_id}")
    public String propertyPage(@PathVariable("catalog") String catalog, @PathVariable("post_id") Long id, Model model, HttpServletRequest request) {
        boolean isBookmarkVisible = false;
        if (request.getSession().getAttribute("user_id") != null) {
            isBookmarkVisible = true;
            String userId = request.getSession().getAttribute("user_id").toString();
            if (favoriteService.isUserFavorThisPost(userId, id)) {
                isBookmarkVisible = false;
            } else {
                model.addAttribute("userId", userId);
            }
        }
        PostHouseNewAPIModel obj = fullPostService.getAFullPostHouse(id);
        model.addAttribute("isBookmarkVisible", isBookmarkVisible);
        model.addAttribute("listPostHouseDetail", obj);
        return "property-detail";
    }

    /**
     * ******* Bookmark controller *******
     */

    @GetMapping("/bookmarked")
    public String bookmarked(HttpServletRequest request, Model model) {
        String username = (String) request.getSession().getAttribute("username");
        String id = String.valueOf(userService.findByUsername(username).get(0).getUserId());
        List<PostCataModel> list = favoriteService.getListFavorByUserId(id);
        List<Long> postIdOfListPost = getListPostIdByURL(list);

        Map<Long, PostCataModel> listBookmarked = zipToMap(postIdOfListPost, list);
        model.addAttribute("listBookmarked", listBookmarked);
        return "bookmarked";
    }

    @GetMapping("/favor/{userid}/{postid}/{catalog}")
    public String addFavorByUserIdAndPostId(@PathVariable("userid") String userid,
                                            @PathVariable("postid") Long postid,
                                            @PathVariable("catalog") String catalog) {
        favoriteService.addFavorPostOfUser(new FavoriteSubmitModel(userid, Math.toIntExact(postid)));
        return "redirect:/property-detail/" + catalog + "/" + postid;
    }

    /**
     * ******* News controller *******
     */

    @GetMapping("/news")
    public String news() {
        return "news";
    }

    @GetMapping("/news-detail")
    public String newsDetail() {
        return "news-detail";
    }

    @GetMapping("/re-news")
    public String realEstateNews() {
        return "re-news";
    }

}