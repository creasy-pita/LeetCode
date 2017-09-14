
加入比较器 Comparable 与 Comparator比较
1 实现 Comparable 接口 ,需要内部 实现compareTo方法
比如
 private static class Person implements Comparable<Person>{
	 ..
	 ..
	 ..
    @Override
    public int compareTo(Person person) {
      return name.compareTo(person.name);
    }
}
2 传入 Comparator ，外部指定
比如 
  /**
   * @desc DescAgeComparator比较器
   *    它是“Person的age的升序比较器”
   */
  private static class DescAgeComparator implements Comparator<Person> {
 
    @Override
    public int compare(Person p1, Person p2) {
      return p2.getAge() - p1.getAge();
    }
  }
  
 3 优缺点： 通过 Comparator的优势 可以灵活指定使用
 4 两者的结合，只需要实例化是指定 哪一类比较器，通过调用compareTo 完成比较
 
 private static class Person implements Comparable<Person>{
	 Comparator comparator = null;
	 public Person(Comparator comparator){
		this.comparator = comparator;
	 }
	 ..
	 ..
    @Override
    public int compareTo(Person person) {
		return comparator.compare(this, person);
      //return name.compareTo(person.name);
    }
}