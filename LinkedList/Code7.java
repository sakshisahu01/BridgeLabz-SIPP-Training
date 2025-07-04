import java.util.*;

class User {
    int userId;
    String name;
    int age;
    List<Integer> friendIds;
    User next;

    User(int userId, String name, int age) {
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.friendIds = new ArrayList<>();
        this.next = null;
    }
}

class SocialMedia {
    User head;

    void addUser(int userId, String name, int age) {
        User newUser = new User(userId, name, age);
        newUser.next = head;
        head = newUser;
    }

    User findUserById(int id) {
        User temp = head;
        while (temp != null) {
            if (temp.userId == id) return temp;
            temp = temp.next;
        }
        return null;
    }

    void addFriend(int user1, int user2) {
        User u1 = findUserById(user1);
        User u2 = findUserById(user2);
        if (u1 != null && u2 != null && user1 != user2) {
            if (!u1.friendIds.contains(user2)) u1.friendIds.add(user2);
            if (!u2.friendIds.contains(user1)) u2.friendIds.add(user1);
        }
    }

    void removeFriend(int user1, int user2) {
        User u1 = findUserById(user1);
        User u2 = findUserById(user2);
        if (u1 != null && u2 != null) {
            u1.friendIds.remove(Integer.valueOf(user2));
            u2.friendIds.remove(Integer.valueOf(user1));
        }
    }

    void displayFriends(int userId) {
        User user = findUserById(userId);
        if (user != null) {
            System.out.print("Friends of " + user.name + " (ID: " + user.userId + "): ");
            for (int fid : user.friendIds) {
                User friend = findUserById(fid);
                if (friend != null) System.out.print(friend.name + " (" + fid + "), ");
            }
            System.out.println();
        }
    }

    void searchUserByName(String name) {
        User temp = head;
        while (temp != null) {
            if (temp.name.equalsIgnoreCase(name)) {
                System.out.println("Found: " + temp.name + ", ID: " + temp.userId + ", Age: " + temp.age);
            }
            temp = temp.next;
        }
    }

    void searchUserById(int id) {
        User user = findUserById(id);
        if (user != null) {
            System.out.println("Found: " + user.name + ", ID: " + user.userId + ", Age: " + user.age);
        }
    }

    void countFriends() {
        User temp = head;
        while (temp != null) {
            System.out.println(temp.name + " has " + temp.friendIds.size() + " friend(s). ");
            temp = temp.next;
        }
    }

    void mutualFriends(int user1, int user2) {
        User u1 = findUserById(user1);
        User u2 = findUserById(user2);
        if (u1 != null && u2 != null) {
            Set<Integer> mutual = new HashSet<>(u1.friendIds);
            mutual.retainAll(u2.friendIds);
            System.out.print("Mutual Friends between " + u1.name + " and " + u2.name + ": ");
            for (int id : mutual) {
                User f = findUserById(id);
                if (f != null) System.out.print(f.name + " (" + id + "), ");
            }
            System.out.println();
        }
    }
}

class Code7 {
    public static void main(String[] args) {
        SocialMedia sm = new SocialMedia();
        sm.addUser(1, "Alice", 25);
        sm.addUser(2, "Bob", 24);
        sm.addUser(3, "Charlie", 23);
        sm.addUser(4, "David", 26);

        sm.addFriend(1, 2);
        sm.addFriend(1, 3);
        sm.addFriend(2, 3);
        sm.addFriend(3, 4);

        sm.displayFriends(1);
        sm.displayFriends(3);

        System.out.println("--- Mutual Friends between Alice and Charlie ---");
        sm.mutualFriends(1, 3);

        System.out.println("--- Count Friends ---");
        sm.countFriends();

        System.out.println("--- Search by Name ---");
        sm.searchUserByName("Bob");

        System.out.println("--- Remove Friend Connection ---");
        sm.removeFriend(1, 3);
        sm.displayFriends(1);
        sm.displayFriends(3);
    }
}
