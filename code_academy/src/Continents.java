public class Continents {
        public static void main(String[] args) {

            int continent = 4;
            String location;
            switch(continent) {
                case 1:  location = "North America: Mexico City, Mexico";
                    break;
                case 2: location = "South America: Sao Paulo, Brazil";
                    break;
                case 3: location = "Europe: Moscow, Russia";
                    break;
                case 4: location = "Africa: Lagos, Nigeria";
                    break;
                case 5: location = "Asia: Shanghai, Chinal";
                    break;
                case 6: location = "Australia: Sydney, Australia";
                    break;
                case 7: location = "Antarctica: McMurdo Station, US";
                    break;
                default: location = "Undefined continent!";
            }
            System.out.println(location);
            //char puzzle = (20 > 10) ? 'A' : 'Z';
        }
    }


