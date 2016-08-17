from fr.johannlecocq.testjava.scripting.interfaces import Calculator as Calc

class Calculator(Calc):
    def __init__(self):
        Calc.__init__(self)
    def add(self,i,j):
        return i+j
    def sub(self,i,j):
        return i-j
    def mul(self,i,j):
        return i*j
    def div(self,i,j):
        return i/j