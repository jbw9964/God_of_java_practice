
Project_directory = ~/Desktop/Coding/God_of_java_practice
Practice_directory = ${Project_directory}/Practice
Scripts_directory = ${Project_directory}/scripts
Code_directory = ${Scripts_directory}/*/code

clean:
	rm -rf ${Practice_directory}/*.class ${Code_directory}/*.class
