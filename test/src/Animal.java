public class Animal {
    private int age;
    private String breed;
    private String gender;

    public Animal(int age, String breed, String gender) {
        this.age = age;
        this.breed = breed;
        this.gender = gender;
    }

    public Animal() {
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
