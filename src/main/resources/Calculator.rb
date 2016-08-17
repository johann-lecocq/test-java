class Calculator
  include Java::fr.johannlecocq.testjava.scripting.interfaces.Calculator

  def add(i,j)
    return i+j
  end

  def mul(i,j)
    return i*j
  end

  def sub(i,j)
    return i-j
  end

  def div(i,j)
    return i/j
  end

end