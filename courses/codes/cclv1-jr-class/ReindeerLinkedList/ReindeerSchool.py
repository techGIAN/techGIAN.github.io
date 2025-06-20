from Reindeer import Reindeer

class ReindeerSchool:

    def __init__(self):
        self.leader = None
        self.count = 0
        print("Reindeer School created.")

    def enrol(self, r):
        '''
	   TO-DO
	'''

    def search(self, s):
        '''
	   TO-DO
	'''
        return False

    def drop(self, r):
        '''
	   TO-DO
	'''
        return ""


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