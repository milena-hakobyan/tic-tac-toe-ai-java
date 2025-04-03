
class A { }

class B extends A { }

class C extends B { }

class D extends B { }

class E extends A { }

class F extends B { }


class BaseReturner {

}

class CReturner extends BaseReturner {

  @Override
  public C get() {
    return new C();
  }
}

class FReturner extends BaseReturner {

  @Override
  public F get() {
    return new F();
  }
}