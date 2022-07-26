/* AdminLogin.java
 Entity for the Admin Login
 Author: Ali Mohamed (219113505)
 Date: 03 April 2022.
*/

package za.ac.cput.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
public class AdminLogin implements Serializable {
    @Id
    @NotNull
    private String adminLoginId;
    @NotNull
    private String adminLoginUsername;
    @NotNull
    private String adminLoginPassword;

    private AdminLogin(Builder builder){
        this.adminLoginId = builder.adminLoginId;
        this.adminLoginUsername = builder.adminLoginUserName;
        this.adminLoginPassword = builder.adminLoginPassword;
    }

    protected AdminLogin() {

    }

    public String getAdminLoginId() {
        return adminLoginId;
    }

    public String getAdminLoginUsername() {
        return adminLoginUsername;
    }

    public String getAdminLoginPassword() {
        return adminLoginPassword;
    }

    @Override
    public String toString() {
        return "AdminLogin{" +
                "adminLoginId=" + adminLoginId +
                ", adminLoginUserName='" + adminLoginUsername + '\'' +
                ", adminLoginPassword='" + adminLoginPassword + '\'' +
                '}';
    }

    public static class Builder{
        private String adminLoginId;
        private String adminLoginUserName;
        private String adminLoginPassword;

        public Builder setAdminLoginId(String adminLoginId) {
            this.adminLoginId = adminLoginId;
            return this;
        }

        public Builder setAdminLoginUserName(String adminLoginUserName) {
            this.adminLoginUserName = adminLoginUserName;
            return this;
        }

        public Builder setAdminLoginPassword(String adminLoginPassword) {
            this.adminLoginPassword = adminLoginPassword;
            return this;
        }

        public Builder copy(AdminLogin adminLogin){
            this.adminLoginId = adminLogin.adminLoginId;
            this.adminLoginUserName = adminLogin.adminLoginUsername;
            this.adminLoginPassword = adminLogin.adminLoginPassword;
            return this;
        }

        public AdminLogin build(){
            return new AdminLogin(this);
        }
    }
}
