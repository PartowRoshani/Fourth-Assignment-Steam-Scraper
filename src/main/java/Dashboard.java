import java.util.List;
import java.util.Scanner;




public class Dashboard {
    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);
        Parser parser =new Parser();

        while (true)
        {
            System.out.println(ColoredOutput.PURPLE+"Welcome");
            System.out.println(ColoredOutput.CYAN+"╔══════════════════════════╗");
            System.out.println(ColoredOutput.CYAN+"║ 1. View all games        ║");
            System.out.println(ColoredOutput.CYAN+"╠══════════════════════════╣");
            System.out.println(ColoredOutput.CYAN+"║ 2. Search game by name   ║");
            System.out.println(ColoredOutput.CYAN+"╠══════════════════════════╣");
            System.out.println(ColoredOutput.CYAN+"║ 3. Sort game by name     ║");
            System.out.println(ColoredOutput.CYAN+"╠══════════════════════════╣");
            System.out.println(ColoredOutput.CYAN+"║ 4. Sort game by rating   ║");
            System.out.println(ColoredOutput.CYAN+"╠══════════════════════════╣");
            System.out.println(ColoredOutput.CYAN+"║ 5. Sort game by price    ║");
            System.out.println(ColoredOutput.CYAN+"╠══════════════════════════╣");
            System.out.println(ColoredOutput.CYAN+"║ 6. Exit                  ║");
            System.out.println(ColoredOutput.CYAN+"╚══════════════════════════╝"+ColoredOutput.RESET);
            System.out.println(ColoredOutput.PURPLE+"Choose an option :"+ColoredOutput.RESET);

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:
                    if (Parser.games.isEmpty()) {
                        try
                        {
                            parser.setUp(); //if list is empty read from HTML
                        }
                        catch (Exception e)
                        {
                            System.out.println(ColoredOutput.RED+"Error loading games: " + e.getMessage()+ColoredOutput.RESET);
                        }
                    }
                    System.out.println("List of Games:");
                    for (Game game : Parser.games)
                    {
                        System.out.println("Name: " + game.getName() +"\n"+ "Rating: " + game.getRating() +"/5"+"\n"+ "Price: " + game.getPrice() + "€"+"\n");
                    }
                    break;

                case 2:
                    if (Parser.games.isEmpty())
                    {
                        try {
                            parser.setUp();
                        }
                        catch (Exception e)
                        {
                            System.out.println(ColoredOutput.RED+"Error loading games: " + e.getMessage()+ColoredOutput.RESET);
                        }
                    }

                    System.out.print("Enter the name of the game you want to search: ");
                    String nameGame = scanner.nextLine().trim().toLowerCase();
                    boolean found = false;
                    for (Game game : Parser.games)
                    {
                        if (game.getName().toLowerCase().contains(nameGame))
                        {
                            System.out.println("Found: " + game.getName() +"\n"+ "Rating: " + game.getRating() +"/5"+ "\n"+ "Price: " + game.getPrice() + "€"+"\n");
                            found = true;
                        }
                    }
                    if (!found) {
                        System.out.println(ColoredOutput.RED+"No game found with the name \"" + nameGame + "\""+ColoredOutput.RESET);
                    }
                    break;

                case 3:
                    if (Parser.games.isEmpty())
                    {
                        try
                        {
                            parser.setUp();
                        }
                        catch (Exception e)
                        {
                            System.out.println(ColoredOutput.RED+"Error loading games: " + e.getMessage()+ColoredOutput.RESET);
                        }
                    }

                    List<Game> sortedGames = Parser.sortByName();

                    System.out.println("\nGames sorted by name :");
                    for (Game game : sortedGames)
                    {
                        System.out.println(game.getName() +"\n"+ "Rating: " + game.getRating() +"\n"+ "Price: " + game.getPrice() + "€"+"\n");
                    }
                    break;

                case 4:
                    if(Parser.games.isEmpty())
                    {
                        try
                        {
                            parser.setUp();
                        }
                        catch (Exception e)
                        {
                            System.out.println(ColoredOutput.RED+"Error loading games: " + e.getMessage()+ColoredOutput.RESET);
                        }
                    }
                    List<Game> SortedGamesByRating = Parser.sortByRating();
                    System.out.println("\nGames sorted by rating :");
                    for(Game game : SortedGamesByRating)
                    {
                        System.out.println(game.getName() +"\n"+ "Rating: " + game.getRating() +"\n"+ "Price: " + game.getPrice() + "€"+"\n");
                    }
                    break;
                case 5:
                    if(Parser.games.isEmpty())
                    {
                        try
                        {
                            parser.setUp();
                        }
                        catch (Exception e)
                        {
                            System.out.println(ColoredOutput.RED+"Error loading games: " + e.getMessage()+ColoredOutput.RESET);
                        }
                    }
                    List <Game> SortedGamesByPrice =  Parser.sortByPrice();
                    for(Game game : SortedGamesByPrice)
                    {
                        System.out.println(game.getName() +"\n"+ "Rating: " + game.getRating() +"\n"+ "Price: " + game.getPrice() + "€"+"\n");
                    }
                    break;
                case 6:
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
