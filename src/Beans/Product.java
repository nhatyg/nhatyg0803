package Beans;

public class Product {
	private int id;
	private String title;
	private String img;
	private float pricenew;
	private float priceold;
	private String name;
	private String info;
	
	public Product(int id, String title, String img, float pricenew, float priceold, String name, String info) {
		this.id = id;
		this.title = title;
		this.img = img;
		this.pricenew = pricenew;
		this.priceold = priceold;
		this.name = name;
		this.info = info;
	}
	public Product(String title, String img, float pricenew, float priceold, String name, String info) {
		this.title = title;
		this.img = img;
		this.pricenew = pricenew;
		this.priceold = priceold;
		this.name = name;
		this.info = info;
	}
	public Product(int id) {
		this.id = id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public float getPricenew() {
		return pricenew;
	}
	public void setPricenew(float pricenew) {
		this.pricenew = pricenew;
	}
	public float getPriceold() {
		return priceold;
	}
	public void setPriceold(float priceold) {
		this.priceold = priceold;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	
	
	

}
