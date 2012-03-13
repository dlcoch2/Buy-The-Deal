// This class allows one to model an "email" and has a couple of methods that
// illustrate how one can manipulate and validate the email string
package my_beans;

public class Email {

    private String emailStr;

    public Email() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Email(String str) {
        super();
        // TODO Auto-generated constructor stub
        emailStr = str;
    }

    public String getEmailStr() {
        return emailStr;
    }

    public void setEmailStr(String emailStr) {
        this.emailStr = emailStr;
    }

    public boolean isValid() {
        boolean result = true;
        int atPosition = emailStr.indexOf("@");
        //******************************
        //*** My additions are below ***
        //******************************
        int periodPosition = emailStr.indexOf(".");
        int lastAtPosition = emailStr.lastIndexOf("@");
        int lastPeriodPosition = emailStr.lastIndexOf(".");

        // I could put these all into fewer if statements, however they are
        // easier to read individually.

        if (emailStr.length() == 0) { // email must not be empty
            result = false;
        } else if (atPosition == -1) {// must have an @ sign
            result = false;
        } else if (atPosition == 0) { // no @ at the beginning
            result = false;
        } else if (atPosition == emailStr.length() - 1) { // no @ at the end
            result = false;
        } else if (periodPosition == -1) { // does not contain a period
            result = false;
        } else if (lastPeriodPosition == emailStr.length() - 1) { // email ends with period
            result = false;
        } else if (periodPosition == 0) { // email starts with a period
            result = false;
        } else if (atPosition != lastAtPosition) { // email can only have one @ sign
            result = false;
        } else if (emailStr.charAt(atPosition + 1) == '.') { // period comes after @ sign
            result = false;
        } else if (lastPeriodPosition < atPosition) { // no period after @ sign when there is a period before
			result = false;
		}

        //******************************
        return result;
    }
}
