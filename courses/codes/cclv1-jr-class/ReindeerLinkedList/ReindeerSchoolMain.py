from Reindeer import Reindeer
from ReindeerSchool import ReindeerSchool

rs = ReindeerSchool()
rs.print_count_status()

rudolph = Reindeer("Rudolph")
rs.enrol(rudolph)
rs.print_count_status()

comet = Reindeer("Comet")
dasher = Reindeer("Dasher")
rs.enrol(comet)
rs.enrol(dasher)
rs.print_count_status()
rs.print_reindeers()

vixen = Reindeer("Vixen")
rs.print_search_status(vixen.name)
rs.enrol(vixen)
rs.print_count_status()

rs.drop(comet)
rs.print_reindeers()
rs.print_count_status()
rs.print_search_status(comet.name)

rs.drop(rudolph)
rs.print_reindeers()
rs.print_count_status()
rs.print_search_status(comet.name)