package jp.ivs.Model;

public class Book {

	protected int id;
	protected String title;
	protected String author;
	protected Float price;
	/**
	 * @return the id
	 */
	
	public int getId() {
		return id;
	}
	/**
	 * @param id
	 * @param title
	 * @param author
	 * @param price
	 */
	public Book(int id, String title, String author, Float price) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.price = price;
	}
	/**
	 * 
	 */
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}
	/**
	 * @param author the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}
	/**
	 * @return the price
	 */
	public Float getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(Float price) {
		this.price = price;
	}
	
}
