/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package my_beans;

import com.cdyne.ws.weatherws.Weather;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.WebServiceRef;

/**
 *
 * @author Derek Cochran
 */
@ManagedBean(name = "DealBean")
@SessionScoped
@PersistenceContext(name = "persistence/LogicalName", unitName = "ITK353ProjectPU")
public class DealBean {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/wsf.cdyne.com/WeatherWS/Weather.asmx.wsdl")
    private Weather service;
    // varaibles for index, register
    private String dealID;
    private String username;
    private String usernameMessage = "<br/>";
    private String welcomeMessage = "Welcome, please sign in or register!";
    private String password;
    private String passwordMessage = "<br/>";
    private String reenterPassword;
    private String reenterPasswordMessage = "<br/>";
    // varables for manage, register
    private String firstName;
    private String firstNameMessage = "<br/>";
    private String lastName;
    private String lastNameMessage = "<br/>";
    private String streetAddress;
    private String streetAddressMessage = "<br/>";
    private String zipCode;
    private String zipCodeMessage = "<br/>";
    private String phone;
    private String phoneMessage = "<br/>";
    private String ccNumber;
    private String ccNumberMessage = "<br/>";
    private String ccIssuer;
    private String ccIssuerMessage = "<br/>";
    private String ccName;
    private String ccNameMessage = "<br/>";
    private String currentPassword;
    private String currentPasswordMessage = "<br/>";
    private String newPassword;
    private String newPasswordMessage = "<br/>";
    private String verifyPassword;
    private String verifyPasswordMessage = "<br/>";
    private String ccMonth;
    private String ccMonthMessage = "";
    private String ccYear;
    private String ccYearMessage = "<br/>";
    private String city;
    private String cityMessage = "";
    private String state;
    private String stateMessage = "<br/>";
    private String email;
    private String emailMessage = "<br/>";
    private String successfulRegister = "";
    private String successfulManage = "";
    private boolean successfulManageCheck = true;
    private boolean loginOptions = false;
    // count for login attempts.  This is used to ensure repeated attempts to enter an acccount are stopped.
    private int loginAttempts = 0;
    // customerID count to be incremented with every new user.
    //boolean variable to determine if the user is logged in
    boolean loggedIn = false;
    private String purchaseDetails;
    @Resource
    private javax.transaction.UserTransaction utx;

    /** Creates a new instance of DealBean */
    public DealBean() {
    }

    // getters and setters for index
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    // getters and setters for manage
    public String getstreetAddress() {
        return streetAddress;
    }

    public void setstreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getCcIssuer() {
        return ccIssuer;
    }

    public void setCcIssuer(String ccIssuer) {
        this.ccIssuer = ccIssuer;
    }

    public String getCcName() {
        return ccName;
    }

    public void setCcName(String ccName) {
        this.ccName = ccName;
    }

    public String getCcNumber() {
        return ccNumber;
    }

    public void setCcNumber(String ccNumber) {
        this.ccNumber = ccNumber;
    }

    public String getCurrentPassword() {
        return currentPassword;
    }

    public void setCurrentPassword(String currentPassword) {
        this.currentPassword = currentPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getVerifyPassword() {
        return verifyPassword;
    }

    public void setVerifyPassword(String verifyPassword) {
        this.verifyPassword = verifyPassword;
    }

    public String getCcMonth() {
        return ccMonth;
    }

    public void setCcMonth(String ccMonth) {
        this.ccMonth = ccMonth;
    }

    public String getCcYear() {
        return ccYear;
    }

    public void setCcYear(String ccYear) {
        this.ccYear = ccYear;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getUsernameMessage() {
        if (!(username == null)) {
            this.validateAccountInfo();
        }
        return usernameMessage;
    }

    public void setUsernameMessage(String usernameMessage) {
        this.usernameMessage = usernameMessage;
    }

    public String getWelcomeMessage() {
        return welcomeMessage;
    }

    public void setWelcomeMessage(String welcomeMessage) {
        this.welcomeMessage = welcomeMessage;
    }

    public String getReenterPassword() {
        return reenterPassword;
    }

    public void setReenterPassword(String reenterPassword) {
        this.reenterPassword = reenterPassword;
    }

    public String getCcIssuerMessage() {
        return ccIssuerMessage;
    }

    public void setCcIssuerMessage(String ccIssuerMessage) {
        this.ccIssuerMessage = ccIssuerMessage;
    }

    public String getCcMonthMessage() {
        return ccMonthMessage;
    }

    public void setCcMonthMessage(String ccMonthMessage) {
        this.ccMonthMessage = ccMonthMessage;
    }

    public String getCcNameMessage() {
        return ccNameMessage;
    }

    public void setCcNameMessage(String ccNameMessage) {
        this.ccNameMessage = ccNameMessage;
    }

    public String getCcNumberMessage() {
        return ccNumberMessage;
    }

    public void setCcNumberMessage(String ccNumberMessage) {
        this.ccNumberMessage = ccNumberMessage;
    }

    public String getCcYearMessage() {
        return ccYearMessage;
    }

    public void setCcYearMessage(String ccYearMessage) {
        this.ccYearMessage = ccYearMessage;
    }

    public String getCityMessage() {
        return cityMessage;
    }

    public void setCityMessage(String cityMessage) {
        this.cityMessage = cityMessage;
    }

    public String getCurrentPasswordMessage() {
        return currentPasswordMessage;
    }

    public void setCurrentPasswordMessage(String currentPasswordMessage) {
        this.currentPasswordMessage = currentPasswordMessage;
    }

    public String getEmailMessage() {
        return emailMessage;
    }

    public void setEmailMessage(String emailMessage) {
        this.emailMessage = emailMessage;
    }

    public String getFirstNameMessage() {
        return firstNameMessage;
    }

    public void setFirstNameMessage(String firstNameMessage) {
        this.firstNameMessage = firstNameMessage;
    }

    public String getLastNameMessage() {
        return lastNameMessage;
    }

    public void setLastNameMessage(String lastNameMessage) {
        this.lastNameMessage = lastNameMessage;
    }

    public String getNewPasswordMessage() {
        return newPasswordMessage;
    }

    public void setNewPasswordMessage(String newPasswordMessage) {
        this.newPasswordMessage = newPasswordMessage;
    }

    public String getPasswordMessage() {
        return passwordMessage;
    }

    public void setPasswordMessage(String passwordMessage) {
        this.passwordMessage = passwordMessage;
    }

    public String getPhoneMessage() {
        return phoneMessage;
    }

    public void setPhoneMessage(String phoneMessage) {
        this.phoneMessage = phoneMessage;
    }

    public String getReenterPasswordMessage() {
        return reenterPasswordMessage;
    }

    public void setReenterPasswordMessage(String reenterPasswordMessage) {
        this.reenterPasswordMessage = reenterPasswordMessage;
    }

    public String getStateMessage() {
        return stateMessage;
    }

    public void setStateMessage(String stateMessage) {
        this.stateMessage = stateMessage;
    }

    public String getStreetAddressMessage() {
        return streetAddressMessage;
    }

    public void setStreetAddressMessage(String streetAddressMessage) {
        this.streetAddressMessage = streetAddressMessage;
    }

    public String getVerifyPasswordMessage() {
        return verifyPasswordMessage;
    }

    public void setVerifyPasswordMessage(String verifyPasswordMessage) {
        this.verifyPasswordMessage = verifyPasswordMessage;
    }

    public String getSuccessfulRegister() {
        return successfulRegister;
    }

    public void setSuccessfulRegister(String successfulRegister) {
        this.successfulRegister = successfulRegister;
    }

    public String getSuccessfulManage() {
        return successfulManage;
    }

    public void setSuccessfulManage(String successfulManage) {
        this.successfulManage = successfulManage;
    }

    public String getPurchaseDetails() {
        return purchaseDetails;
    }

    public void setPurchaseDetails(String purchaseDetails) {
        this.purchaseDetails = purchaseDetails;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getZipCodeMessage() {
        return zipCodeMessage;
    }

    public void setZipCodeMessage(String zipCodeMessage) {
        this.zipCodeMessage = zipCodeMessage;
    }

    // methods
    public String buy() {
        String page = "buy";
        if (loggedIn == false) {
            this.clearMessages();
            page = "loginOptions";
            loginOptions = true;
        }
        return page;
    }

    public String register() {
        String registerConfirmation = "register";
        boolean validAccountInfo = this.validateAccountInfo();
        boolean validPasswordInfo = this.validatePasswordInfo();
        boolean validContactInfo = this.validateContactInfo();
        boolean validCCInfo = this.validateCCInfo();

        if (validContactInfo && validPasswordInfo && validCCInfo && validAccountInfo) {
            registerConfirmation = "homeLoggedIn";
            insertNewCustomer();

            this.welcomeMessage = "Thank you for registering, " + this.username;
            loggedIn = true;

            Customers customer = findCustomerByID(username);
            this.username = customer.getUsername();
            this.password = customer.getPassword();
            this.firstName = customer.getFirstname();
            this.lastName = customer.getLastname();
            this.streetAddress = customer.getStreetaddress();
            this.city = customer.getCity();
            this.state = customer.getState();
            this.zipCode = customer.getZipcode();
            this.phone = customer.getPhone();
            this.email = customer.getEmail();
            this.ccNumber = customer.getCcno();
            this.ccIssuer = customer.getCctype();
            this.ccName = customer.getCcname();
            this.ccMonth = customer.getCcexpmonth();
            this.ccYear = customer.getCcexpyear();
        }

        return registerConfirmation;
    }

    private void insertNewCustomer() {
        Customers customer = new Customers();
        customer.setUsername(username);
        customer.setPassword(password);
        customer.setFirstname(firstName);
        customer.setLastname(lastName);
        customer.setStreetaddress(streetAddress);
        customer.setCity(city);
        customer.setState(state);
        customer.setZipcode(zipCode);
        customer.setPhone(phone);
        customer.setEmail(email);
        customer.setCcno(ccNumber);
        customer.setCctype(ccIssuer);
        customer.setCcname(ccName);
        customer.setCcexpmonth(ccMonth);
        customer.setCcexpyear(ccYear);

        this.persist(customer);
    }

    public String manageSubmit() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
        String response = "manage";
        boolean validContactInfo = this.validateContactInfo();
        boolean validCCInfo = this.validateCCInfo();
        boolean changePassword = this.validPasswordChange();
        Customers customer = findCustomerByID(username);


        if (customer != null && validContactInfo && validCCInfo) {
            if (successfulManageCheck) {
                if (changePassword) {
                    customer.setPassword(this.verifyPassword);
                }
                customer.setFirstname(this.firstName);
                customer.setLastname(this.lastName);
                customer.setStreetaddress(this.streetAddress);
                customer.setCity(this.city);
                customer.setState(this.state);
                customer.setZipcode(zipCode);
                customer.setPhone(this.phone);
                customer.setEmail(this.email);
                customer.setCcno(this.ccNumber);
                customer.setCctype(this.ccIssuer);
                customer.setCcname(this.ccName);
                customer.setCcexpmonth(this.ccMonth);
                customer.setCcexpyear(this.ccYear);
                this.update(customer);
                successfulManage = "<script type=\"text/javascript\">alert('You have successfully updated your account.')</script>";
            }
        } else {
            response = "manage";
        }

        return response;
    }

    public String registerLink() {
        this.clearMessages();
        return "register";
    }

    public String logout() {
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext ec = context.getExternalContext();
        final HttpServletRequest request = (HttpServletRequest) ec.getRequest();
        request.getSession(false).invalidate();

        return "index";
    }

    public String manageLink() {
        System.out.println("PASSWORD manage link: " + this.password);

        String response = "manage";
        this.clearMessages();
        return response;
    }

    public String indexLink() {
        this.clearMessages();
        String response = "homeLoggedOut";
        if (loggedIn) {
            response = "homeLoggedIn";
        }

        return response;
    }

    // private methods
    private void clearMessages() {
        passwordMessage = "<br/>";
        reenterPasswordMessage = "<br/>";
        successfulRegister = "";
        loginOptions = false;
        successfulManage = "";
    }

    private boolean validateAccountInfo() {
        Customers customer = findCustomerByID(username);
        boolean isValid = true;
        if (username.isEmpty()) {
            usernameMessage = "<br/>";
        } else if (username.length() < 6 || username.length() > 20) {
            usernameMessage = "<font color=\"red\" size=\"2\">* Username must be between 6 to 20 characters.</font><br/><br/>";
            isValid = false;
        } else if (customer != null) {
            usernameMessage = "<font color=\"red\" size=\"2\">* Username already exists in our database.</font><br/><br/>";
            isValid = false;
        } else {
            usernameMessage = "<br/>";
        }


        return isValid;
    }

    private boolean validatePasswordInfo() {
        boolean isValid = true;

        if (password != null && password.length() < 6 || password.length() > 12) {
            passwordMessage = "<font color=\"red\" size=\"2\">* Password must be between 6 to 12 characters.</font><br/><br/>";
            isValid = false;
            password = null;
            reenterPassword = null;
        } else {
            passwordMessage = "<br/>";
        }

        if (password != null && !reenterPassword.equals(password)) {
            reenterPasswordMessage = "<font color=\"red\" size=\"2\">* Passwords do not match.</font><br/><br/>";
            isValid = false;
            password = null;
            reenterPassword = null;
        } else {
            reenterPasswordMessage = "<br/>";
        }
        return isValid;
    }

    private boolean validateContactInfo() {
        boolean isValid = true;
        if (firstName.isEmpty()) {
            firstNameMessage = "<font color=\"red\" size=\"2\">* First Name field must not be blank.</font><br/><br/>";
            isValid = false;
        } else {
            firstNameMessage = "<br/>";
        }

        if (lastName.isEmpty()) {
            lastNameMessage = "<font color=\"red\" size=\"2\">* Last Name field must not be blank.</font><br/><br/>";
            isValid = false;
        } else {
            lastNameMessage = "<br/>";
        }

        if (streetAddress.isEmpty()) {
            streetAddressMessage = "<font color=\"red\" size=\"2\">* Street Address field must not be blank.</font><br/><br/>";
            isValid = false;
        } else {
            streetAddressMessage = "<br/>";
        }

        if (city.isEmpty()) {
            cityMessage = "<font color=\"red\" size=\"2\">* City field must not be blank.</font><br/>";
            isValid = false;
        } else {
            cityMessage = "";
        }

        if (state.isEmpty()) {
            stateMessage = "<font color=\"red\" size=\"2\">* State field must not be blank.</font><br/><br/>";
            isValid = false;
        } else {
            stateMessage = "<br/>";
        }

        if (zipCode.length() != 5) {
            zipCodeMessage = "<font color=\"red\" size=\"2\">* Zip Code field must not be blank.</font><br/>";
            isValid = false;
        } else if (this.isNum(zipCode) == false) {
            zipCodeMessage = "<font color=\"red\" size=\"2\">* Zip Code must be a number.</font><br/>";
            isValid = false;
        } else {
            zipCodeMessage = "<br/>";
        }

        if (phone.length() != 10) {
            phoneMessage = "<font color=\"red\" size=\"2\">* Phone number must be 10 digits long.</font><br/><br/>";
            isValid = false;
        } else if (this.isNum(phone) == false) {
            phoneMessage = "<font color=\"red\" size=\"2\">* Phone number cannot contain any characters. (Ex. '(', ')', '-')</font><br/><br/>";
            isValid = false;
        } else {
            phoneMessage = "<br/>";
        }

        if (email.isEmpty()) {
            emailMessage = "<font color=\"red\" size=\"2\">* Email field must not be blank.</font><br/><br/>";
            isValid = false;
        } else {
            Email emailValidator = new Email(email);
            if (emailValidator.isValid() == false) {
                emailMessage = "<font color=\"red\" size=\"2\">* Email is not in the format yourname@example.com</font><br/><br/>";
            } else {
                emailMessage = "<br/>";
            }
        }
        return isValid;
    }

    private boolean validateCCInfo() {
        boolean isValid = true;

        if (ccNumber.length() != 16) {
            ccNumberMessage = "<font color=\"red\" size=\"2\">* Credit card number must be 16 digits long.</font><br/><br/>";
            isValid = false;
        } else if (this.isNum(ccNumber) == false) {
            ccNumberMessage = "<font color=\"red\" size=\"2\">* Credit card number must contain only numbers.</font><br/><br/>";
            isValid = false;
        } else {
            ccNumberMessage = "<br/>";
        }

        if (ccIssuer.equals("none")) {
            ccIssuerMessage = "<font color=\"red\" size=\"2\">* A card issuer must be selected.</font><br/><br/>";
            isValid = false;
        } else {
            ccIssuerMessage = "<br/>";
        }

        if (ccName.isEmpty()) {
            ccNameMessage = "<font color=\"red\" size=\"2\">* The name on the credit card must be provided.</font><br/><br/>";
            isValid = false;
        } else {
            ccNameMessage = "<br/>";
        }

        boolean validCCDate = true;

        if (ccMonth.length() > 2 || ccMonth.length() < 1) {
            ccMonthMessage = "<font color=\"red\" size=\"2\">* Expiration month must be 1 or 2 digits long.</font><br/>";
            isValid = false;
            validCCDate = false;
        } else if (this.isNum(ccMonth) == false) {
            ccMonthMessage = "<font color=\"red\" size=\"2\">* Expiration month cannot contain characters.</font><br/>";
            isValid = false;
            validCCDate = false;
        } else if (Integer.parseInt(ccMonth) < 1 || Integer.parseInt(ccMonth) > 12) {
            ccMonthMessage = "<font color=\"red\" size=\"2\">* Invalid range for expiration month.</font><br/>";
            isValid = false;
            validCCDate = false;
        } else {
            ccMonthMessage = "";
        }

        if (ccYear.length() != 4) {
            ccYearMessage = "<font color=\"red\" size=\"2\">* Expiration year must be 4 digits long.</font><br/><br/>";
            isValid = false;
            validCCDate = false;
        } else if (this.isNum(ccYear) == false) {
            ccYearMessage = "<font color=\"red\" size=\"2\">* Expiration year cannot contain characters.</font><br/><br/>";
            isValid = false;
            validCCDate = false;
        } else {
            ccYearMessage = "<br/>";
        }

        if (validCCDate) {
            Calendar todaysDate = Calendar.getInstance();
            if (todaysDate.get(Calendar.YEAR) > Integer.parseInt(ccYear)) {
                ccYearMessage = "<font color=\"red\" size=\"2\">* Current credit card is expired.</font><br/><br/>";
                isValid = false;
            } else if (todaysDate.get(Calendar.YEAR) == Integer.parseInt(ccYear) && todaysDate.get(Calendar.MONTH) + 1 > Integer.parseInt(ccMonth)) {
                ccYearMessage = "<font color=\"red\" size=\"2\">* Current credit card is expired.</font><br/><br/>";
                isValid = false;
            }
        }
        return isValid;
    }

    private boolean validPasswordChange() {
        System.out.println("PASSWORD manage link: " + this.password);
        System.out.println("CURRENT PASSWORD: " + this.currentPassword);
        System.out.println("NEW PASSWORD: " + this.newPassword);
        System.out.println("VERIFY PASSWORD: " + this.verifyPassword);
        boolean changePassword = true;
        if (this.currentPassword.isEmpty()) {
            changePassword = false;
            currentPasswordMessage = "<br/>";
            newPasswordMessage = "<br/>";
            verifyPasswordMessage = "<br/>";
            successfulManageCheck = true;
        } else if (this.currentPassword.equals(this.password)) {
            if (this.newPassword.length() < 6 || this.newPassword.length() > 12) {
                newPasswordMessage = "<font color=\"red\" size=\"2\">* New Password must be between 6 to 12 characters</font><br/><br/>";
                currentPasswordMessage = "<br/>";
                verifyPasswordMessage = "<br/>";
                changePassword = false;
                successfulManageCheck = false;
            } else if (this.newPassword.equals(this.verifyPassword)) {
                changePassword = true;
                currentPasswordMessage = "<br/>";
                newPasswordMessage = "<br/>";
                verifyPasswordMessage = "<br/>";
                successfulManageCheck = true;
            } else {
                verifyPasswordMessage = "<font color=\"red\" size=\"2\">* Passwords do not match</font><br/><br/>";
                currentPasswordMessage = "<br/>";
                newPasswordMessage = "<br/>";
                changePassword = false;
                successfulManageCheck = false;
            }
        } else if (!(this.currentPassword.equals(this.password))) {
            currentPasswordMessage = "<font color=\"red\" size=\"2\">* Incorrect Password</font><br/><br/>";
            newPasswordMessage = "<br/>";
            verifyPasswordMessage = "<br/>";
            changePassword = false;
            successfulManageCheck = false;
        }
        return changePassword;
    }

    private boolean isNum(String number) {
        boolean isNum = true;
        try {
            Double.parseDouble(number);
        } catch (NumberFormatException e) {
            isNum = false;
            e.printStackTrace();
        }
        for (int i = 0; i < number.length(); i++) {
            if (number.charAt(i) == '.') {
                isNum = false;
                i = number.length();
            }
        }
        return isNum;
    }

    // Database Methods
    public String login() {
        Customers customer = findCustomerByID(username);
        String response = "";
        if (loginAttempts < 4) {
            if (customer != null) {
                System.out.println("User: " + customer.getUsername());
                System.out.println("Password: " + customer.getPassword());
                if (username.equals(customer.getUsername()) && password.equals(customer.getPassword())) {
                    this.welcomeMessage = "Welcome Back " + this.username;
                    loggedIn = true;
                    this.username = customer.getUsername();
                    this.password = customer.getPassword();
                    System.out.println("TEST HERE: " + password);
                    this.firstName = customer.getFirstname();
                    this.lastName = customer.getLastname();
                    this.streetAddress = customer.getStreetaddress();
                    this.city = customer.getCity();
                    this.state = customer.getState();
                    this.zipCode = customer.getZipcode();
                    this.phone = customer.getPhone();
                    this.email = customer.getEmail();
                    this.ccNumber = customer.getCcno();
                    this.ccIssuer = customer.getCctype();
                    this.ccName = customer.getCcname();
                    this.ccMonth = customer.getCcexpmonth();
                    this.ccYear = customer.getCcexpyear();

                    response = "homeLoggedIn";
                    loginOptions = false;
                } else {
                    this.welcomeMessage = "Invalid username or password";
                    if (loginOptions) {
                        response = "loginOptions";
                    } else {
                        response = "homeLoggedOut";
                    }
                    loginAttempts++;
                }
            } else {
                this.welcomeMessage = "Invalid username or password";
                if (loginOptions) {
                    response = "loginOptions";
                } else {
                    response = "homeLoggedOut";
                }
                loginAttempts++;
            }
        } else {
            this.welcomeMessage = "You have failed too many logins";
            if (loginOptions) {
                response = "loginOptions";
            } else {
                response = "homeLoggedOut";
            }
            loginAttempts++;
        }

        return response;
    }

    protected void persist(Object object) {
        try {
            Context ctx = (Context) new InitialContext().lookup("java:comp/env");
            utx.begin();
            EntityManager em = (EntityManager) ctx.lookup("persistence/LogicalName");
            em.persist(object);
            utx.commit();
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            throw new RuntimeException(e);
        }
    }

    public Customers findCustomerByID(String username) {
        Customers customer = null;
        try {
            Context ctx = (Context) new InitialContext().lookup("java:comp/env");
            utx.begin();
            EntityManager em = (EntityManager) ctx.lookup("persistence/LogicalName");
            customer = em.find(Customers.class, username);
            utx.commit();
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            throw new RuntimeException(e);
        }
        return customer;
    }

    public Deal findDealByID(String dealID) {
        Deal deal = null;
        try {
            Context ctx = (Context) new InitialContext().lookup("java:comp/env");
            utx.begin();
            EntityManager em = (EntityManager) ctx.lookup("persistence/LogicalName");
            deal = em.find(Deal.class, dealID);
            utx.commit();
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            throw new RuntimeException(e);
        }
        return deal;
    }

    public Purchase findPurchaseByID(Integer purchaseID) {
        Purchase purchase = null;
        try {
            Context ctx = (Context) new InitialContext().lookup("java:comp/env");
            utx.begin();
            EntityManager em = (EntityManager) ctx.lookup("persistence/LogicalName");
            purchase = em.find(Purchase.class, purchaseID);
            utx.commit();
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            throw new RuntimeException(e);
        }
        return purchase;
    }

    protected void delete(Object object) {
        try {
            Context ctx = (Context) new InitialContext().lookup("java:comp/env");
            utx.begin();
            EntityManager em = (EntityManager) ctx.lookup("persistence/LogicalName");
            // need to be managed by the em before removal. Do this by performing a merge
            em.remove(em.merge(object));
            utx.commit();
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            throw new RuntimeException(e);
        }
    }

    protected void update(Object object) {
        try {
            Context ctx = (Context) new InitialContext().lookup("java:comp/env");
            utx.begin();
            EntityManager em = (EntityManager) ctx.lookup("persistence/LogicalName");
            em.merge(object);
            utx.commit();
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            throw new RuntimeException(e);
        }
    }

    protected void purchaseQuery() {
        try {
            Context ctx = (Context) new InitialContext().lookup("java:comp/env");
            utx.begin();
            EntityManager em = (EntityManager) ctx.lookup("persistence/LogicalName");

            Query q = em.createQuery("SELECT p FROM Purchase p WHERE p.username = :username");
            q.setParameter("username", username);
            List<Purchase> purchaseList = q.getResultList(); // use q.getSingleResult() if expecting just one
            purchaseDetails = "";
            for (Purchase e : purchaseList) {
//                purchaseDetails += getPurchaseDetails(e) + getPurchaseDeal(e.getDealid()) + "<hr/>";
                purchaseDetails += getPurchaseDetails(e) + "<hr/>";
            }

            utx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            throw new RuntimeException(e);
        }
    }

    public String getPurchaseDetails(Purchase p) {
        String purchaseDetail = "";
        if (p != null) {
            purchaseDetail += "Order ID: " + p.getPurchaseid() + "<br/>";
            purchaseDetail += "Order Date/Time: " + p.getTimestamp() + "<br/><br/>";
            purchaseDetail += "Deal Name: " + p.getTitle() + "<br/>";
            purchaseDetail += "Deal Description: " + p.getDescription() + "<br/>";
            purchaseDetail += "Deal Price: " + p.getPrice() + "<br/>";
        } else {
            purchaseDetail = "No Orders on record";
        }
        return purchaseDetail;
    }

    public String presentDeal() {
        String deal = "<img src=\"resources/images/iphoneDeal.jpg\" />";
        Calendar todaysDate = Calendar.getInstance();

        if (todaysDate.get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY) {
            deal = "<img src=\"resources/images/flashDriveDeal.jpg\" />";
            dealID = "0002";
        }
        if (todaysDate.get(Calendar.DAY_OF_WEEK) == Calendar.TUESDAY) {
            deal = "<img src=\"resources/images/iphoneDeal.jpg\" />";
            dealID = "0001";
        }
        if (todaysDate.get(Calendar.DAY_OF_WEEK) == Calendar.WEDNESDAY) {
            deal = "<img src=\"resources/images/macBookCaseDeal.jpg\" />";
            dealID = "0003";
        }
        if (todaysDate.get(Calendar.DAY_OF_WEEK) == Calendar.THURSDAY) {
            deal = "<img src=\"resources/images/pixelOvenMittsDeal.jpg\" />";
            dealID = "0005";
        }
        if (todaysDate.get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY) {
            deal = "<img src=\"resources/images/vaderToastDeal.jpg\" />";
            dealID = "0004";
        }

        return deal;
    }

    @SuppressWarnings("static-access")
    public void redirect() throws IOException, InterruptedException {
        // Thread thread = new Thread();
        //thread.sleep(2500);
        FacesContext.getCurrentInstance().getExternalContext().redirect("faces/homeLoggedOut.xhtml");
    }

    public String getDealName() {
        Deal deal = this.findDealByID(dealID);
        String dealName = deal.getTitle();
        return dealName;
    }

    public String getDealDescription() {
        Deal deal = this.findDealByID(dealID);
        String dealDescription = deal.getDescription();
        return dealDescription;
    }

    public String getDealPrice() {
        Deal deal = this.findDealByID(dealID);
        String dealPrice = deal.getPrice() + "";
        return dealPrice;
    }

    public String completePurchase() {
        Deal deal = this.findDealByID(dealID);

        String[] to = new String[1];
        to[0] = this.email;
        String[] cc = new String[1];
        to[0] = this.email;
        String[] bcc = new String[1];
        to[0] = this.email;

        String emailDetails = "You purchased: " + deal.getTitle() + "\n"
                + "Deal Description: " + deal.getDescription() + "\n"
                + "Deal Price: " + deal.getPrice() + "\n"
                + "Thank you for your purchase!";


        //This is for google
        Mail.sendMail("itk353buythedeal@gmail.com", "buythedeal", "smtp.gmail.com", "465", "true",
                "true", true, "javax.net.ssl.SSLSocketFactory", "false", to, cc, bcc,
                "Your Buy The Deal Purchase", emailDetails);

        Purchase purchase = new Purchase();

        String DATE_FORMAT_NOW = "yyyy-MM-dd HH:mm:ss";
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
        //String timestamp = sdf.format(cal.getTime());

        purchase.setDealid(deal.getDealid());
        purchase.setTimestamp(cal.getTime());
        purchase.setTotalprice(deal.getPrice());
        purchase.setUsername(username);
        purchase.setTitle(deal.getTitle());
        purchase.setDescription(deal.getDescription());
        purchase.setPrice(deal.getPrice());

        this.persist(purchase);

        return "orderConfirmation";
    }

    public String getWeather() {
        String result = "";
        try { // Call Web Service Operation
            com.cdyne.ws.weatherws.WeatherSoap port = service.getWeatherSoap();
            // TODO initialize WS operation arguments here
            java.lang.String zip = "61704";
            // TODO process result here
            result = "<p><font color=\"white\" face=\"arial\">" + port.getCityWeatherByZIP(zip).getTemperature() + "°F </font></p>";
            System.out.println("Result = " + result);
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }
        return result;
    }

    public String getPreviousOrders() {
        this.purchaseQuery();
        return "previousOrders";
    }
}
