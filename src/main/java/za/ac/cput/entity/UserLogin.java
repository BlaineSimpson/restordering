/* UserLogin.java
 Entity for the User Login
 Author: Ali Mohamed (219113505)
 Date: 03 April 2022
*/

package za.ac.cput.entity;

public class UserLogin {
    private int userLoginId;
    private String userLoginUsername;
    private String userLoginPassword;

    private UserLogin(Builder builder){
        this.userLoginId = builder.userLoginId;
        this.userLoginUsername = builder.userLoginUsername;
        this.userLoginPassword = builder.userLoginPassword;
    }

    public int getUserLoginId() {
        return userLoginId;
    }

    public String getUserLoginUsername() {
        return userLoginUsername;
    }

    public String getUserLoginPassword() {
        return userLoginPassword;
    }

    @Override
    public String toString() {
        return "UserLogin{" +
                "userLoginId=" + userLoginId +
                ", userLoginUsername='" + userLoginUsername + '\'' +
                ", userLoginPassword='" + userLoginPassword + '\'' +
                '}';
    }

    public static class Builder{
        private int userLoginId;
        private String userLoginUsername;
        private String userLoginPassword;

        public Builder setUserLoginId(int userLoginId) {
            this.userLoginId = userLoginId;
            return this;
        }

        public Builder setUserLoginUsername(String userLoginUsername) {
            this.userLoginUsername = userLoginUsername;
            return this;
        }

        public Builder setUserLoginPassword(String userLoginPassword) {
            this.userLoginPassword = userLoginPassword;
            return this;
        }

        public Builder copy(UserLogin userLogin){
            this.userLoginId = userLogin.userLoginId;
            this.userLoginUsername = userLogin.userLoginUsername;
            this.userLoginPassword = userLogin.userLoginPassword;
            return this;
        }

        public UserLogin build(){
            return new UserLogin(this);
        }
    }
}
