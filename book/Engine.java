package book;
import java.util.ArrayList;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import book.Item.TYPE;

public class Engine {
	public static void main(String[] args) {
		Item_bank ask = new Item_bank(TYPE.ASK);
		Item_bank bid = new Item_bank(TYPE.BID);
		ask.add_item(32.1, 4500);
		ask.add_item(32, 1000);
		ask.add_item(33, 100);
		bid.add_market(1500);
		bid.add_item(32, 100);
		bid.add_item(31.9, 100);
		System.out.println(ask);
		System.out.println(bid);
		open_engine(ask, bid);
	}
	
	public static void open_engine(Item_bank ask, Item_bank bid) {
		ArrayList<Double> ask_items = ask.sortbykey();
		ArrayList<Double> bid_items = bid.sortbykey();
		Double open_price = null;
		
		//Check if overlap, Limit piority
		System.out.println("Bid checker");
		if(ask_items.size() > 0 && bid_items.size() > 0) {
			double firstAsk = ask_items.get(0);
			double firstBid = bid_items.get(0);
			System.out.println(firstAsk);
			System.out.println(firstBid);
			if(firstAsk > firstBid) {
				System.out.println("Overlap");
			}
		}
		
		if(bid.has_market() && ask.has_market()) {
			
		} else if(bid.has_market()) {
			System.out.println("Bid has market");
			open_price = clear_market(bid.get_market_sum(), ask_items, ask);
		} else if(ask.has_market()) {
			System.out.println("Ask has market");
			open_price = clear_market(ask.get_market_sum(), bid_items, bid);
		} else {
			// Open_price wait for first market or overlap
		}
	}
	
	public static double clear_market(int market_qty, ArrayList<Double> items, Item_bank bank) {
		double price = items.get(0);
		for(int i = 0; market_qty > 0; i++) {
			price = items.get(i);
			System.out.println(bank.get_quantity(price));
			market_qty -= bank.get_quantity(price);
		}
		System.out.println(price);
		return price;
	}
}

class Item_bank {
	TYPE type;
	Item_List market;
	HashMap<Double, Item_List> q;

	public Item_bank(TYPE type) {
		this.type = type;
		market = new Item_List();
		q = new HashMap<Double, Item_List>();
	}

	public void add_item(double price, int qty) {
		Item item = new Item(type, qty, price);
		if (q.containsKey(price)) {
			Item_List ip = q.get(price);
			ip.add_item(item);
			q.put(price, ip);
		} else {
			q.put(price, new Item_List(item));
		}
	}

	public void add_market(int qty) {
		market.add_item(new Item(type, qty));
	}
	
	public boolean has_market() {
		return market.get_list().size() != 0;
	}
	
	public int get_quantity(double price) {
		return q.get(price).get_sum_qty();
	}

	@Override
	public String toString() {
		String r = "";
		if (market.get_list().size() != 0) {
			int sum = get_market_sum();

			r = "Market QTY:" + sum + "\n";
			for (Item x : market.get_list()) {
				r += x.toString() + "\n";
			}
			r += "\n";
		}
		
		for (double x : sortbykey()) {
			r += x + "\n";
			r += toStringItems(q.get(x).get_list()) + "\n";
		}
		return String.format("%s\n%s", type.toString(), r);
	}
	
	public int get_market_sum() {
		return market.get_sum_qty();
	}

	private String toStringItems(List<Item> list) {
		String r = "";
		for (Item i : list)
			r += i.toString() + "\n";
		return r;
	}

	public ArrayList<Double> sortbykey() {
		ArrayList<Double> sortedKeys = new ArrayList<Double>(q.keySet());
		Collections.sort(sortedKeys);
//		if(type == TYPE.ASK) {
			Collections.reverse(sortedKeys);
//		}
		return sortedKeys;
	}
}

class Item_List {
	List<Item> q;

	Item_List(Item i) {
		this();
		q.add(i);
	}
	
	Item_List() {
		q = new ArrayList<>();
	}

	List<Item> get_list() {
		return q;
	}

	void add_item(Item i) {
		q.add(i);
	}
	
	int get_sum_qty() {
		int sum = 0;
		for (Item i: q) sum += i.get_qty();
		return sum;
	}
}

class Item {
	enum TYPE {
		BID, ASK
	}

	TYPE type;
	double price;
	int qty;
	boolean market = false;

	public Item(TYPE type, int qty, double price) {
		this(type, qty);
		this.price = price;
	}

	public Item(TYPE type, int qty) {
		this.type = type;
		this.qty = qty;
	}

	public double get_price() {
		if (market)
			throw new UnsupportedOperationException();
		else
			return price;
	}

	public int get_qty() {
		return qty;
	}

	public boolean is_market() {
		return market;
	}

	@Override
	public String toString() {
		return String.format("Qty: %d     Price:%f", qty, price);
	}
}

