package heaps.medium;

import java.util.*;

//https://leetcode.com/problems/design-a-food-rating-system/description/
// 2353. Design a Food Rating System
class FoodRatings {
    private Map<String, Integer> foodToRating;
    private Map<String, String> foodToCuisine;
    private Map<String, PriorityQueue<Food>> cuisineToFoods;
    private Map<String, Food> foodMap;

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        foodToRating = new HashMap<>();
        foodToCuisine = new HashMap<>();
        cuisineToFoods = new HashMap<>();
        foodMap = new HashMap<>();

        for (int i = 0; i < foods.length; i++) {
            foodToRating.put(foods[i], ratings[i]);
            foodToCuisine.put(foods[i], cuisines[i]);
            Food food = new Food(foods[i], ratings[i]);
            foodMap.put(foods[i], food);

            cuisineToFoods.putIfAbsent(cuisines[i], new PriorityQueue<>((a, b) -> {
                if (a.rating != b.rating) {
                    return b.rating - a.rating;
                }
                return a.name.compareTo(b.name);
            }));

            cuisineToFoods.get(cuisines[i]).offer(food);
        }
    }

    public void changeRating(String food, int newRating) {
        String cuisine = foodToCuisine.get(food);
        Food oldFood = foodMap.get(food);

        // Remove the old rating
        cuisineToFoods.get(cuisine).remove(oldFood);

        // Update the rating
        foodToRating.put(food, newRating);
        Food newFood = new Food(food, newRating);
        foodMap.put(food, newFood);

        // Add the new rating
        cuisineToFoods.get(cuisine).offer(newFood);
    }

    public String highestRated(String cuisine) {
        return cuisineToFoods.get(cuisine).peek().name;
    }

    private static class Food {
        String name;
        int rating;

        Food(String name, int rating) {
            this.name = name;
            this.rating = rating;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;
            Food food = (Food) o;
            return rating == food.rating && Objects.equals(name, food.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, rating);
        }
    }
}
