import fr.johannlecocq.testjava.scripting.interfaces.Calculator

class GroovyCalculator implements Calculator{

    @Override
    int add(int i, int j) {
        return i+j;
    }

    @Override
    int mul(int i, int j) {
        return i*j;
    }

    @Override
    int sub(int i, int j) {
        return i-j;
    }

    @Override
    float div(int i, int j) {
        return i/j;
    }
}