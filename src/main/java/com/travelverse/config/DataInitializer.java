package com.travelverse.config;

import com.travelverse.entity.*;
import com.travelverse.entity.User.Role;
import com.travelverse.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired private UserRepository userRepository;
    @Autowired private CategoryRepository categoryRepository;
    @Autowired private DestinationRepository destinationRepository;
    @Autowired private TravelPackageRepository packageRepository;
    @Autowired private ExperienceRepository experienceRepository;
    @Autowired private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) {
        if (userRepository.count() > 0) return;

        // Create Admin User
        User admin = new User("Admin User", "admin@travelverse.com", passwordEncoder.encode("admin123"), Role.ADMIN);
        admin.setPhone("+1-555-0100");
        admin.setCountry("USA");
        admin.setPreferredTravelStyle("Luxury");
        userRepository.save(admin);

        // Create Regular Users
        User user1 = new User("John Traveler", "john@travelverse.com", passwordEncoder.encode("user123"), Role.USER);
        user1.setPhone("+1-555-0101");
        user1.setCountry("USA");
        user1.setPreferredTravelStyle("Adventure");
        userRepository.save(user1);

        User user2 = new User("Sarah Explorer", "sarah@travelverse.com", passwordEncoder.encode("user123"), Role.USER);
        user2.setPhone("+44-555-0102");
        user2.setCountry("UK");
        user2.setPreferredTravelStyle("Cultural");
        userRepository.save(user2);

        // Create Categories
        Category beach = createCategory("Beach", "Relax on pristine beaches", "🏖️");
        Category adventure = createCategory("Adventure", "Thrilling outdoor experiences", "🏔️");
        Category mountains = createCategory("Mountains", "Majestic mountain retreats", "⛰️");
        Category luxury = createCategory("Luxury", "Premium travel experiences", "✨");
        Category cultural = createCategory("Cultural", "Immerse in local cultures", "🏛️");
        Category wildlife = createCategory("Wildlife", "Explore nature and wildlife", "🦁");
        Category historical = createCategory("Historical", "Discover ancient wonders", "🏰");
        Category romantic = createCategory("Romantic", "Perfect for couples", "💕");
        Category family = createCategory("Family", "Fun for the whole family", "👨‍👩‍👧‍👦");
        Category solo = createCategory("Solo", "Independent travel adventures", "🎒");

        // Create Destinations
        Destination paris = createDestination("Paris", "France",
            "The City of Light enchants visitors with its iconic Eiffel Tower, world-class museums, romantic bridges, and delectable cuisine.",
            "https://images.unsplash.com/photo-1502602898657-3e91760cbb34?w=800",
            new BigDecimal("4.8"), new BigDecimal("150"), cultural,
            "[\"Eiffel Tower\",\"Louvre Museum\",\"Notre-Dame\",\"Montmartre\",\"Seine River Cruise\"]",
            "[\"Visit the Eiffel Tower at sunset\",\"Explore the Louvre Museum\",\"Walk along the Champs-Élysées\",\"Take a Seine River cruise\",\"Explore Montmartre\"]",
            "[\"Best visited in spring or fall\",\"Book museum tickets in advance\",\"Get a Paris Museum Pass\",\"Use the Metro for easy transport\"]",
            "London, Amsterdam, Brussels", "48.8566", "2.3522");
        paris.setFeatured(true);
        paris.setLongDescription("Paris, the capital of France, is one of the most visited cities in the world. Known for its art, fashion, gastronomy, and culture, Paris offers something for every traveler.");
        paris.setAverageBudget("$150-300/day");
        destinationRepository.save(paris);

        Destination dubai = createDestination("Dubai", "UAE",
            "A futuristic city of superlatives featuring the world's tallest building, luxurious shopping, and stunning desert landscapes.",
            "https://images.unsplash.com/photo-1512453979798-5ea266f8880c?w=800",
            new BigDecimal("4.7"), new BigDecimal("200"), luxury,
            "[\"Burj Khalifa\",\"Palm Jumeirah\",\"Dubai Mall\",\"Desert Safari\",\"Dubai Marina\"]",
            "[\"Visit the Burj Khalifa\",\"Go on a Desert Safari\",\"Shop at Dubai Marina Mall\",\"Visit the Gold Souk\",\"Take a dhow cruise\"]",
            "[\"Visit during winter months\",\"Book desert safari in advance\",\"Dress modestly in public areas\",\"Try local Emirati cuisine\"]",
            "Abu Dhabi, Oman, Bahrain", "25.2048", "55.2708");
        dubai.setFeatured(true);
        dubai.setLongDescription("Dubai is a city of superlatives, home to the world's tallest building, the largest shopping mall, and some of the most luxurious hotels on Earth.");
        dubai.setAverageBudget("$200-500/day");
        destinationRepository.save(dubai);

        Destination bali = createDestination("Bali", "Indonesia",
            "An island paradise offering lush rice terraces, ancient temples, stunning beaches, and a vibrant cultural scene.",
            "https://images.unsplash.com/photo-1537996194471-e657df975ab4?w=800",
            new BigDecimal("4.6"), new BigDecimal("80"), beach,
            "[\"Ubud Rice Terraces\",\"Tanah Lot Temple\",\"Seminyak Beach\",\"Mount Batur\",\"Nusa Penida\"]",
            "[\"Visit Ubud Rice Terraces\",\"Watch sunset at Tanah Lot\",\"Snorkel in Nusa Penida\",\"Climb Mount Batur\",\"Explore Uluwatu Temple\"]",
            "[\"Visit during dry season (April-October)\",\"Respect local customs at temples\",\"Negotiate prices at markets\",\"Try Balinese cuisine\"]",
            "Java, Lombok, Komodo Island", "-8.3405", "115.0920");
        bali.setFeatured(true);
        bali.setLongDescription("Bali is known for its forested volcanic mountains, iconic rice paddies, beaches, and coral reefs. The island is home to religious sites such as cliffside Uluwatu Temple.");
        bali.setAverageBudget("$80-150/day");
        destinationRepository.save(bali);

        Destination tokyo = createDestination("Tokyo", "Japan",
            "A mesmerizing blend of ultramodern and traditional, where neon-lit skyscrapers meet historic temples and exquisite cuisine.",
            "https://images.unsplash.com/photo-1540959733332-eab4deabeeaf?w=800",
            new BigDecimal("4.8"), new BigDecimal("180"), cultural,
            "[\"Senso-ji Temple\",\"Shibuya Crossing\",\"Tokyo Tower\",\"Meiji Shrine\",\"Akihabara\"]",
            "[\"Visit Senso-ji Temple\",\"Experience Shibuya Crossing\",\"Explore Akihabara\",\"Visit Meiji Shrine\",\"Take a day trip to Mt. Fuji\"]",
            "[\"Get a JR Pass for trains\",\"Learn basic Japanese phrases\",\"Carry cash for small shops\",\"Visit during cherry blossom season\"]",
            "Kyoto, Osaka, Hakone", "35.6762", "139.6503");
        tokyo.setFeatured(true);
        tokyo.setLongDescription("Tokyo, Japan's busy capital, mixes the ultramodern with the traditional, from neon-lit skyscrapers to historic temples.");
        tokyo.setAverageBudget("$180-350/day");
        destinationRepository.save(tokyo);

        Destination switzerland = createDestination("Switzerland", "Switzerland",
            "A breathtaking Alpine paradise with pristine lakes, charming villages, world-class skiing, and stunning mountain scenery.",
            "https://images.unsplash.com/photo-1531366936337-7c912a4589a7?w=800",
            new BigDecimal("4.9"), new BigDecimal("250"), mountains,
            "[\"Jungfrau\",\"Lake Lucerne\",\"Zermatt\",\"Interlaken\",\"Lucerne\"]",
            "[\"Take the Jungfrau Railway\",\"Ski in Zermatt\",\"Cruise Lake Lucenne\",\"Go paragliding in Interlaken\",\"Visit the Chillon Castle\"]",
            "[\"Visit during summer or winter\",\"Buy a Swiss Travel Pass\",\"Pack layers for mountain weather\",\"Try Swiss chocolate and fondue\"]",
            "France, Italy, Austria, Germany", "46.8182", "8.2275");
        switzerland.setFeatured(true);
        switzerland.setLongDescription("Switzerland is a mountainous Central European country, home to numerous lakes, villages, and the high peaks of the Alps.");
        switzerland.setAverageBudget("$250-400/day");
        destinationRepository.save(switzerland);

        Destination maldives = createDestination("Maldives", "Maldives",
            "A tropical haven of crystal-clear waters, overwater villas, vibrant coral reefs, and unparalleled luxury.",
            "https://images.unsplash.com/photo-1514282401047-d79a71a590e8?w=800",
            new BigDecimal("4.7"), new BigDecimal("300"), beach,
            "[\"Malé Atoll\",\"Baa Atoll\",\"Ari Atoll\",\"Vaadhoo Island\",\"Maafushi\"]",
            "[\"Stay in an overwater villa\",\"Go scuba diving\",\"Snorkel with manta rays\",\"Watch bioluminescent plankton\",\"Enjoy a sunset dolphin cruise\"]",
            "[\"Visit between November and April\",\"Book resorts well in advance\",\"Respect local customs\",\"Pack reef-safe sunscreen\"]",
            "Sri Lanka, Seychelles, Mauritius", "3.2028", "73.2207");
        maldives.setFeatured(true);
        maldives.setLongDescription("The Maldives is a tropical nation in the Indian Ocean composed of 26 ring-shaped atolls, which are made up of more than 1,000 coral islands.");
        maldives.setAverageBudget("$300-600/day");
        destinationRepository.save(maldives);

        Destination london = createDestination("London", "United Kingdom",
            "A historic and cosmopolitan city with royal palaces, world-class museums, iconic landmarks, and vibrant neighborhoods.",
            "https://images.unsplash.com/photo-1513635269975-59663e0ac1ad?w=800",
            new BigDecimal("4.6"), new BigDecimal("200"), cultural,
            "[\"Big Ben\",\"Tower Bridge\",\"Buckingham Palace\",\"British Museum\",\"London Eye\"]",
            "[\"Visit the Tower of London\",\"Ride the London Eye\",\"Explore the British Museum\",\"Walk along South Bank\",\"See Buckingham Palace\"]",
            "[\"Get an Oyster card for transport\",\"Book West End theatre tickets\",\"Visit on weekends for markets\",\"Try afternoon tea\"]",
            "Paris, Amsterdam, Brussels", "51.5074", "-0.1278");
        london.setFeatured(true);
        london.setLongDescription("London, the capital of England and the United Kingdom, is a 21st-century city with history stretching back to Roman times.");
        london.setAverageBudget("$200-350/day");
        destinationRepository.save(london);

        Destination newyork = createDestination("New York", "USA",
            "The city that never sleeps, with iconic skyline, Broadway shows, diverse neighborhoods, and world-famous landmarks.",
            "https://images.unsplash.com/photo-1496442226666-8d4d0e62e6e9?w=800",
            new BigDecimal("4.7"), new BigDecimal("220"), cultural,
            "[\"Statue of Liberty\",\"Central Park\",\"Times Square\",\"Brooklyn Bridge\",\"Empire State Building\"]",
            "[\"Visit the Statue of Liberty\",\"Walk through Central Park\",\"See a Broadway show\",\"Walk the Brooklyn Bridge\",\"Explore Times Square\"]",
            "[\"Walk as much as possible\",\"Book Broadway tickets early\",\"Visit museums on free days\",\"Try diverse cuisines in different neighborhoods\"]",
            "Boston, Philadelphia, Washington DC", "40.7128", "-74.0060");
        newyork.setFeatured(true);
        newyork.setLongDescription("New York City comprises 5 boroughs sitting where the Hudson River meets the Atlantic Ocean. At its core is Manhattan.");
        newyork.setAverageBudget("$220-400/day");
        destinationRepository.save(newyork);

        // Create Travel Packages
        createPackage("Bali Paradise", "Bali", "5 Days / 4 Nights", new BigDecimal("45000"),
            "Experience the magic of Bali with visits to ancient temples, lush rice terraces, and pristine beaches. This package includes luxury accommodation, guided tours, and authentic Balinese dining experiences.",
            new BigDecimal("4.8"), "https://images.unsplash.com/photo-1537996194471-e657df975ab4?w=800", bali,
            "[\"Day 1: Arrival and transfer to hotel, Evening beach dinner\",\"Day 2: Ubud Rice Terraces and Sacred Monkey Forest\",\"Day 3: Tanah Lot Temple and Uluwatu Temple with Kecak dance\",\"Day 4: Water sports and beach day in Nusa Dua\",\"Day 5: Departure with souvenir shopping\"]",
            "[\"Luxury beachfront resort\",\"Private pool villa\"]", "[\"Temple visits\",\"Rice terrace trek\",\"Beach activities\",\"Cultural shows\"]",
            "Private car, Airport transfers", "[\"Breakfast\",\"Lunch on Day 2,3,4\",\"Welcome dinner\"]",
            "[\"4 nights accommodation\",\"Airport transfers\",\"Daily breakfast\",\"Guided tours\",\"Entrance fees\"]",
            "[\"Flights\",\"Travel insurance\",\"Personal expenses\",\"Optional activities\"]");

        createPackage("Swiss Escape", "Switzerland", "7 Days / 6 Nights", new BigDecimal("95000"),
            "Discover the stunning beauty of Switzerland with visits to Alpine villages, pristine lakes, and breathtaking mountain landscapes. Enjoy luxury train rides and world-class dining.",
            new BigDecimal("4.9"), "https://images.unsplash.com/photo-1531366936337-7c912a4589a7?w=800", switzerland,
            "[\"Day 1: Zurich arrival, city tour\",\"Day 2: Lucerne and Lake cruise\",\"Day 3: Jungfrau region\",\"Day 4: Interlaken adventure activities\",\"Day 5: Zermatt and Matterhorn\",\"Day 6: Geneva and Montreux\",\"Day 7: Departure\"]",
            "[\"5-star hotel in Zurich\",\"Boutique hotel in Lucerne\",\"Mountain resort in Zermatt\"]",
            "[\"Lake cruise\",\"Jungfrau Railway\",\"Paragliding\",\"Wine tasting\"]",
            "Swiss Rail Pass, Private transfers", "[\"All breakfasts\",\"5 dinners\",\"2 lunches\"]",
            "[\"6 nights accommodation\",\"Swiss Rail Pass\",\"All tours\",\"Mountain excursions\"]",
            "[\"Flights\",\"Lunch on most days\",\"Personal expenses\"]");

        createPackage("Dubai Luxury Experience", "Dubai", "5 Days / 4 Nights", new BigDecimal("70000"),
            "Indulge in the ultimate luxury Dubai experience with stays at world-class hotels, desert adventures, and exclusive city tours.",
            new BigDecimal("4.7"), "https://images.unsplash.com/photo-1512453979798-5ea266f8880c?w=800", dubai,
            "[\"Day 1: Arrival, Burj Khalifa sunset visit\",\"Day 2: Desert safari with BBQ dinner\",\"Day 3: Dubai Marina, Palm Jumeirah, Atlantis\",\"Day 4: Gold Souk, Spice Souk, Dhow cruise\",\"Day 5: Dubai Mall and departure\"]",
            "[\"Burj Al Arab or similar\",\"Atlantis The Palm\"]",
            "[\"Desert safari\",\"Dhow cruise\",\"City tour\",\"Shopping\"]",
            "Luxury SUV, Airport transfers", "[\"All breakfasts\",\"Desert BBQ dinner\",\"Dhow cruise dinner\"]",
            "[\"4 nights 5-star accommodation\",\"Airport transfers\",\"Desert safari\",\"Dhow cruise\",\"City tour\"]",
            "[\"Flights\",\"Lunches\",\"Personal expenses\"]");

        createPackage("Tokyo Discovery", "Tokyo", "6 Days / 5 Nights", new BigDecimal("85000"),
            "Immerse yourself in the fascinating culture of Tokyo with visits to ancient temples, modern districts, and culinary adventures.",
            new BigDecimal("4.8"), "https://images.unsplash.com/photo-1540959733332-eab4deabeeaf?w=800", tokyo,
            "[\"Day 1: Arrival, Shinjuku exploration\",\"Day 2: Asakusa, Senso-ji, Akihabara\",\"Day 3: Meiji Shrine, Harajuku, Shibuya\",\"Day 4: Day trip to Mt. Fuji\",\"Day 5: Tsukiji Market, Ginza, Odaiba\",\"Day 6: Departure\"]",
            "[\"Premium hotel in Shinjuku\",\"Traditional Ryokan experience\"]",
            "[\"Temple visits\",\"Mt. Fuji day trip\",\"Cooking class\",\"Tea ceremony\"]",
            "JR Pass, Airport express", "[\"All breakfasts\",\"2 special dinners\"]",
            "[\"5 nights accommodation\",\"JR Pass\",\"Temple entry fees\",\"Cooking class\",\"Mt. Fuji tour\"]",
            "[\"Flights\",\"Most lunches\",\"Personal expenses\"]");

        createPackage("Maldives Relaxation", "Maldives", "4 Days / 3 Nights", new BigDecimal("120000"),
            "Escape to paradise with overwater villa stays, crystal clear waters, and unlimited relaxation in the Maldives.",
            new BigDecimal("4.7"), "https://images.unsplash.com/photo-1514282401047-d79a71a590e8?w=800", maldives,
            "[\"Day 1: Arrival by seaplane, villa check-in\",\"Day 2: Snorkeling and spa day\",\"Day 3: Sunset dolphin cruise and dinner\",\"Day 4: Departure\"]",
            "[\"Overwater villa with private pool\"]",
            "[\"Snorkeling\",\"Spa treatments\",\"Dolphin cruise\",\"Beach dining\"]",
            "Seaplane transfers", "[\"All meals included\"]",
            "[\"3 nights overwater villa\",\"Seaplane transfers\",\"All meals\",\"Snorkeling equipment\",\"Spa session\"]",
            "[\"Flights\",\"Additional spa treatments\",\"Diving courses\"]");

        createPackage("European Explorer", "Multiple Cities", "10 Days / 9 Nights", new BigDecimal("150000"),
            "Explore the best of Europe with visits to Paris, Rome, Barcelona, and Amsterdam in one unforgettable journey.",
            new BigDecimal("4.6"), "https://images.unsplash.com/photo-1502602898657-3e91760cbb34?w=800", paris,
            "[\"Day 1-3: Paris - Eiffel Tower, Louvre, Versailles\",\"Day 4-6: Rome - Colosseum, Vatican, Amalfi\",\"Day 7-8: Barcelona - Sagrada Familia, Park Guell\",\"Day 9-10: Amsterdam - Canals, Van Gogh Museum, departure\"]",
            "[\"4-star hotels in each city\"]",
            "[\"Guided city tours\",\"Museum entries\",\"Wine tasting in Paris\",\"Cooking class in Rome\"]",
            "High-speed trains, Airport transfers", "[\"All breakfasts\",\"4 dinners\"]",
            "[\"9 nights accommodation\",\"Inter-city trains\",\"Airport transfers\",\"Guided tours\"]",
            "[\"Flights\",\"Most lunches\",\"Personal expenses\"]");

        // Create Experiences
        createExperience("Northern Lights Safari", "Iceland", "Adventure",
            "Witness the spectacular Northern Lights dancing across the Arctic sky on this guided nighttime adventure.",
            "https://images.unsplash.com/photo-1531366936337-7c912a4589a7?w=800",
            new BigDecimal("180"), new BigDecimal("4.8"), "4 hours", true);

        createExperience("Sahara Desert Camping", "Morocco", "Adventure",
            "Spend a magical night under the stars in the Sahara Desert with camel riding and traditional Berber entertainment.",
            "https://images.unsplash.com/photo-1509023464722-18d996393ca8?w=800",
            new BigDecimal("120"), new BigDecimal("4.7"), "2 days", true);

        createExperience("Tuscany Wine Tour", "Italy", "Cultural",
            "Journey through the rolling hills of Tuscany, visiting historic wineries and enjoying world-class wine tasting.",
            "https://images.unsplash.com/photo-1523528283115-9bf9b1699245?w=800",
            new BigDecimal("250"), new BigDecimal("4.9"), "Full day", true);

        createExperience("Scuba Diving in Great Barrier Reef", "Australia", "Adventure",
            "Dive into the crystal-clear waters of the Great Barrier Reef and explore vibrant coral ecosystems.",
            "https://images.unsplash.com/photo-1544551763-46a013bb70d5?w=800",
            new BigDecimal("200"), new BigDecimal("4.8"), "6 hours", true);

        createExperience("Cherry Blossom Tour", "Japan", "Cultural",
            "Experience the ethereal beauty of Japan's cherry blossom season in Kyoto's ancient temples and gardens.",
            "https://images.unsplash.com/photo-1522383225653-ed111181a951?w=800",
            new BigDecimal("150"), new BigDecimal("4.9"), "Full day", true);

        createExperience("Safari Wildlife Expedition", "Kenya", "Wildlife",
            "Embark on an unforgettable wildlife safari through Kenya's Masai Mara, home to the Big Five.",
            "https://images.unsplash.com/photo-1547471080-7cc2caa01a7e?w=800",
            new BigDecimal("350"), new BigDecimal("4.8"), "3 days", true);

        createExperience("Bali Temple & Rice Terrace Trek", "Indonesia", "Cultural",
            "Explore Bali's sacred temples and walk through stunning terraced rice paddies with a local guide.",
            "https://images.unsplash.com/photo-1537996194471-e657df975ab4?w=800",
            new BigDecimal("60"), new BigDecimal("4.7"), "Full day", true);

        createExperience("Machu Picchu Inca Trail", "Peru", "Adventure",
            "Trek the legendary Inca Trail to Machu Picchu, one of the New Seven Wonders of the World.",
            "https://images.unsplash.com/photo-1526392060635-9d6019884377?w=800",
            new BigDecimal("400"), new BigDecimal("4.9"), "4 days", true);

        System.out.println("✅ Sample data initialized successfully!");
        System.out.println("📧 Admin login: admin@travelverse.com / admin123");
        System.out.println("📧 User login: john@travelverse.com / user123");
    }

    private Category createCategory(String name, String description, String icon) {
        return categoryRepository.save(new Category(name, description, icon));
    }

    private Destination createDestination(String name, String country, String description,
            String image, BigDecimal rating, BigDecimal price, Category category,
            String popularAttractions, String thingsToDo, String travelTips,
            String nearbyDestinations, String latitude, String longitude) {
        Destination dest = new Destination(name, country, description, image, rating, price);
        dest.setCategory(category);
        dest.setPopularAttractions(popularAttractions);
        dest.setThingsToDo(thingsToDo);
        dest.setTravelTips(travelTips);
        dest.setNearbyDestinations(nearbyDestinations);
        dest.setLatitude(latitude);
        dest.setLongitude(longitude);
        return destinationRepository.save(dest);
    }

    private void createPackage(String name, String destination, String duration, BigDecimal price,
            String description, BigDecimal rating, String image, Destination dest,
            String itinerary, String hotels, String activities, String transportation,
            String meals, String inclusions, String exclusions) {
        TravelPackage pkg = new TravelPackage(name, destination, duration, price, description, rating, image);
        pkg.setDestinationEntity(dest);
        pkg.setItinerary(itinerary);
        pkg.setHotels(hotels);
        pkg.setActivities(activities);
        pkg.setTransportation(transportation);
        pkg.setMeals(meals);
        pkg.setInclusions(inclusions);
        pkg.setExclusions(exclusions);
        pkg.setFeatured(true);
        packageRepository.save(pkg);
    }

    private void createExperience(String name, String destination, String category,
            String description, String image, BigDecimal price, BigDecimal rating,
            String duration, boolean featured) {
        Experience exp = new Experience(name, destination, category, description, image, price, rating, duration);
        exp.setFeatured(featured);
        experienceRepository.save(exp);
    }
}
