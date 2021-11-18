package domain;

import com.jdbctest.database.DogDBFunctions;

public class Runner {

	public static void main(String[] args) {
	
		Dog fiftySix = new Dog("connor but new","sausage",21,30.435f);
		
		DogDBFunctions test = new DogDBFunctions();
		
//		test.create(new Dog("connor","sausage",24,165.96f));
//		test.create(new Dog("jordan","rotweiler",26,178.98f));
//		test.create(new Dog("smith","pomeranian",12,2.07f));
//		test.create(new Dog("barry","golden retreiver",4,8.94f));
//		test.create(new Dog("broken dog","chihuahua",79,0.23f));
//		test.create(new Dog("toby","big good boi",3,7.39f));
//		test.create(new Dog("gunther","bulldog",8,12.75f));
//		test.create(new Dog("stitch","pug",2,12.32f));
//		test.create(new Dog("fluffy","yorkshire terrier",9,8.34f));
//		test.create(new Dog("molly","staffordshire bull terrier",19,17.48f));
		
//		test.delete(5);
		
//		test.update(37, fiftySix);
		
//		test.createPrepared(new Dog("testy","newbreed",99,199.95f));
		
//		test.updatePrepared(43, fiftySix);
		
//		test.deletePrepared(43);
		
//		test.readByID(42);
		
		
//		System.out.println(test.readByID(42));
		System.out.println(test.readByIDPrepared(42));
		System.out.println(test.readAll());
	}
	
}
