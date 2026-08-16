package entities;

public class User {

    public final String studentFirstName;
    public final String studentLastName;
    public final String studentEmail;
    public final String gender;
    public final String phoneNumber;
    public final int dayOfBirth;
    public final String monthOfBirth;
    public final String yearOfBirth;
    public final String subjects;
    public final String hobbies;
    public final String picture;
    public final String address;
    public final String state;
    public final String city;

    private User(UserBuilder userBuilder) {
        this.studentFirstName = userBuilder.studentFirstName;
        this.studentLastName = userBuilder.studentLastName;
        this.studentEmail = userBuilder.studentEmail;
        this.gender = userBuilder.gender;
        this.phoneNumber = userBuilder.phoneNumber;
        this.dayOfBirth = userBuilder.dayOfBirth;
        this.monthOfBirth = userBuilder.monthOfBirth;
        this.yearOfBirth = userBuilder.yearOfBirth;
        this.subjects = userBuilder.subjects;
        this.hobbies = userBuilder.hobbies;
        this.picture = userBuilder.picture;
        this.address = userBuilder.address;
        this.state = userBuilder.state;
        this.city = userBuilder.city;
    }

    public static class UserBuilder {

        public String studentFirstName = "";
        public String studentLastName = "";
        public String studentEmail = "";
        public String gender = "";
        public String phoneNumber = "";
        public int dayOfBirth = 1;
        public String monthOfBirth = "";
        public String yearOfBirth = "";
        public String subjects = "";
        public String hobbies = "";
        public String picture = "";
        public String address = "";
        public String state = "";
        public String city = "";

        public UserBuilder() {
        }

        public UserBuilder studentFirstName(String studentFirstName) {
            this.studentFirstName = studentFirstName;
            return this;
        }

        public UserBuilder studentLastName(String studentLastName) {
            this.studentLastName = studentLastName;
            return this;
        }

        public UserBuilder studentEmail(String studentEmail) {
            this.studentEmail = studentEmail;
            return this;
        }

        public UserBuilder gender(String gender) {
            this.gender = gender;
            return this;
        }

        public UserBuilder phoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public UserBuilder dayOfBirth(int dayOfBirth) {
            this.dayOfBirth = dayOfBirth;
            return this;
        }

        public UserBuilder monthOfBirth(String monthOfBirth) {
            this.monthOfBirth = monthOfBirth;
            return this;
        }

        public UserBuilder yearOfBirth(String yearOfBirth) {
            this.yearOfBirth = yearOfBirth;
            return this;
        }

        public UserBuilder subjects(String subjects) {
            this.subjects = subjects;
            return this;
        }

        public UserBuilder hobbies(String hobbies) {
            this.hobbies = hobbies;
            return this;
        }

        public UserBuilder picture(String picture) {
            this.picture = picture;
            return this;
        }

        public UserBuilder address(String address) {
            this.address = address;
            return this;
        }

        public UserBuilder state(String state) {
            this.state = state;
            return this;
        }

        public UserBuilder city(String city) {
            this.city = city;
            return this;
        }

        public User build() {
            return new User(this);
        }

    }

    @Override
    public String toString() {
        return "User{" +
                "studentFirstName='" + studentFirstName + '\'' +
                ", studentLastName='" + studentLastName + '\'' +
                ", studentEmail='" + studentEmail + '\'' +
                ", gender='" + gender + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", dayOfBirth=" + dayOfBirth +
                ", monthOfBirth='" + monthOfBirth + '\'' +
                ", yearOfBirth='" + yearOfBirth + '\'' +
                ", subjects='" + subjects + '\'' +
                ", hobbies='" + hobbies + '\'' +
                ", picture='" + picture + '\'' +
                ", address='" + address + '\'' +
                ", state='" + state + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
