/** Class Description of MyPerson */
public class Person {
	/**The class field */
	private String name;
	private String last;
	private String birthday;
	
	/** Constructor of MyClass() */
	public Person(String name, String last, String birthday){
		this.name = name;
		this.last = last;
		this.birthday = birthday;
		
		
	}
	   public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
}