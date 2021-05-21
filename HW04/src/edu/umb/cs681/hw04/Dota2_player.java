package edu.umb.cs681.hw04;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Dota2_player {
	private String name;
	private int year_of_games, age, num_lose, num_win;
	

	public Dota2_player(String name,int  year_of_games, int age,int  num_lose,int num_win){
		this.name = name;
		this.year_of_games = year_of_games;
		this.num_lose = num_lose;
		this.num_win = num_win;
		
	}

	public String getName() {
		return name;
	}

	public int getYearofGame() {
		return year_of_games;
	}

	public int getCenturies() {
		return age;
	}

	public int getNumoflost() {
		return num_lose;
	}

	public int getNumofWin() {
		return num_win;
	}


	
          @Override
        public String toString() {
        	
        	return this.name +" "+ this.year_of_games+" "+ this.age+" "+this.num_lose+" "+this.num_win;
        }

	public static void main(String[] args) {
		
		List<Dota2_player> list=new ArrayList<Dota2_player>();
		list.add(new Dota2_player("Miracle", 4, 22, 28, 93));
		list.add(new Dota2_player("Mushi", 9, 29, 60, 105));
		list.add(new Dota2_player("W33", 6, 26, 55, 90));
		list.add(new Dota2_player("Maybe", 8, 27, 38, 187));
		list.add(new Dota2_player("Ame", 6, 25, 23,101 ));
		
		
		
		int max_year = list.stream().map((Dota2_player palyer) ->palyer.getYearofGame() )
				.reduce(0, (result,price)->result > price ? result : price);
		
		System.out.println("year of play dota2 : "+max_year);
		
		
		
		int min_lost = list.stream().map((Dota2_player palyer) ->palyer.getNumoflost() )
				.reduce(1000, (result, price)->price>result ? result : price);
		
		System.out.println(" Minimum of game lost : "+min_lost);
		
		int y=0;
		int count = list.stream().map(x->y+1).reduce(0,(a,b)->a+b);
		System.out.println("Total number of palyer in list:"+count);
		
		
		System.out.println("palyer sorted by number of year_of_games:");
		List<Dota2_player> sortedbyYears=list.stream().sorted(Comparator.comparingInt(Dota2_player::getYearofGame)).collect(Collectors.toList());
		sortedbyYears.forEach(System.out::println);
		
		
		System.out.println("palyer sorted by Number of win:");
		List<Dota2_player> sortedbynumofWin=list.stream().sorted(Comparator.comparingInt(Dota2_player::getNumofWin)).collect(Collectors.toList());
		sortedbynumofWin.forEach(System.out::println);
		
		System.out.println("palyer sorted by Number of lost:");
		List<Dota2_player> sortedbynumoflost=list.stream().sorted(Comparator.comparingInt(Dota2_player::getNumoflost)).collect(Collectors.toList());
		sortedbynumoflost.forEach(System.out::println);

	}

}
