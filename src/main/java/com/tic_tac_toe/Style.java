package com.tic_tac_toe;


public final class Style {
    private static final String RESET = "\u001B[0m";
    private static final String BOLD = "\u001B[1m";
    private static final String WHITEBG = "\u001B[47m\u001B[4m";
    private static final String RED = "\u001B[38;5;196m";
    private static final String GREEN = "\u001B[38;5;46m";
    private static final String YELLOW = "\u001B[33m";
    private static final String BLUE = "\u001B[38;5;21m";
    private static final String PINK = "\u001B[38;5;200m";
    private static final String ORANGE =  "\u001B[38;5;208m";
    
  
    private Style(){}
        public static String colorRed(String text){
            return RED + text + RESET;
        }

        public static String colorGreen(String text){
            return GREEN + text + RESET;
        }

        public static String colorBlue(String text){
            return BLUE + text + RESET;
        }

        public static String colorYellow(String text){
            return YELLOW + text + RESET;
        }

        public static String colorBold(String text){
            return BOLD + text + RESET;
        }

         public static String colorBlueBold(String text){
            return BLUE + BOLD + text + RESET;
        }
  
               public static String colorPink(String text){
            return PINK + text + RESET;
        }
                   public static String colorOrange(String text){
            return ORANGE + text + RESET;
        }

        public static String titleStyle (String text){
            return WHITEBG + BLUE + BOLD + text + RESET;
        }

        public static String playeToken(char token){
            if(token == 'X') return colorRed(String.valueOf(token));
            if(token == 'O') return colorGreen(String.valueOf(token));
            return String.valueOf(token);

        }

   
}
