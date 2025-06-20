from Reindeer import Reindeer

class ReindeerSchool:

    def __init__(self):
        self.leader = None
        self.count = 0
        print("Reindeer School created.")

    def enrol(self, r):
        if (self.leader is None):
            self.leader = r
        else:
            temp = self.leader
            while temp.next is not None:
                temp = temp.next
            temp.next = r
        self.count += 1
        self.print_enrol_status(r.name)

    def search(self, s):
        temp = self.leader
        while temp is not None:
            if temp.name == s:
                return True
            temp = temp.next
        return False

    def drop(self, r):
        if self.count == 0 or not self.search(r.name):
            return ""
        name = ""
        temp = self.leader
        if r == temp:
            if self.count == 1:
                self.leader = None
            else:
                self.leader = r.next
        else:
            while temp.next is not None:
                if temp.next == r:
                    temp.next = r.next
                    break

        self.count -= 1
        self.print_drop_status(r.name)
        return r.name


    # ===========================================
    # Mainly for checking status; DO NOT MODIFY!
    # ===========================================

    def print_enrol_status(self, r_name):
        print("Reindeer " + r_name + " has been enrolled in the Reindeer School.")

    def print_drop_status(self, r_name):
        print("Reindeer " + r_name + " has been dropped from the Reindeer School.")

    def print_search_status(self, r_name):
        if self.search(r_name):
            print("Reindeer " + r_name + " is enrolled in the Reindeer School.")
        else:
            print("Reindeer " + r_name + " is not enrolled in the Reindeer School.")

    def print_count_status(self):
        if self.count == 0:
            print("There are currently " + str(self.count) + " reindeers enrolled in the Reindeer School.")
        else:
            print("There are currently " + str(self.count) + " reindeers enrolled in the Reindeer School, led by " + self.leader.name + ".")

    def print_reindeers(self):
        S = "["
        temp = self.leader
        while (temp is not None):
            S += temp.name + " --> "
            temp = temp.next
        if self.count > 0:
            S = S[:-5]
        S += "]"
        print("Reindeers: " + S)