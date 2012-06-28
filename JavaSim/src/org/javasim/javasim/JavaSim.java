//' THIS IS JAVASIM

// Javasim is a minimal collection of functions to support
// discrete-event simulation programming in Java.
// Random-number and variate generation routines borrowed from simlib (Law 2007)
// and translated into Java by Luis de la Torre

// Set up event handling



package org.javasim.javasim;

public class JavaSim {
	public double clock;                     //simulation global clock
	public EventCalendar calendar;     //event calendar

	// Set up Collections to be reinitialized between replications

	Public TheCTStats As New Collection   ' continuous-time statistics
	Public TheDTStats As New Collection   ' discrete-time statistics
	Public TheQueues As New Collection    ' queues
	Public TheResources As New Collection ' resources
}
