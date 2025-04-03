class Shape {
    public double area() {
        return 0;
    }
}

class Triangle extends Shape {
    double height;
    double base;

    public double area(){
        return (height*base)/2;
    }
}

class Circle extends Shape {
    double radius;

    public double area() {
        return radius * radius*Math.PI;
    }
}

class Square extends Shape {
    double side;

    @Override
    public double area() {
        return side*side;
    }
}

class Rectangle extends Shape {
    double width;
    double height;

    @Override
    public double area() {
        return width*height;
    }
}