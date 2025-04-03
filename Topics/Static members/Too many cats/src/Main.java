class Cat {
    static int counter;
    String name;
    int age;
    // write static and instance variables

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
        counter++;
        if(counter>5)
            System.out.println("You have too many cats");

        // do not forget to check the number of cats
    }

    public static int getNumberOfCats() {
        return counter;
    }
}