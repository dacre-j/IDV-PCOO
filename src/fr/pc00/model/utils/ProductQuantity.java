package fr.pc00.model.utils;

import fr.pc00.implement.Product;

public class ProductQuantity
{
	private Product	_product;
	private int		_quantity;
	
	public ProductQuantity(Product product, int qty)
	{
		this._product = product;
		this._quantity = qty;
	}
	
	public Product getProduct() { return(this._product);}
	public int getQuantity() { return(this._quantity);}
}
