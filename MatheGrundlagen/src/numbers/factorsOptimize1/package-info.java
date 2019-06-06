/**
 * Beispiel für die Berechnung aller Teiler einer ganzen Zahl.
 * 
 * Das Beispiel und auch die Verbesserungen in der Berechnung
 * stammen aus der Aufgabe 4.3 "Teiler" aus
 * Kösters, Pagel, Six: Software Engineering - Aufgaben und Lösungen,
 * Oldenbourg Verlag, 1997.
 * 
 * Diese Version enthält Logging-Ausgaben mit log4j2, die insbesondere
 * die Anzahl der Schleifendurchläufe der while-Schleife ausgibt.
 * 
 * Diese Version enthält die erste Optimierung. Wir können die Anzahl der Schleifendurchläufe
 * drastisch reduzieren, da wir nicht bis zur eingegebenen Zahl iterieren müssen, sondern
 * schon bei this.number div 2 aufhören können.
 * 
 * @author  $Author: brill $
 * @version $Revision: #2 $
 */
package numbers.factorsOptimize1;