package sml;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

// TODO: write a JavaDoc for the class
// This class contains information about labels and the address with each label.
// An instruction is referred by the label.
/**
 *
 * @author ...
 */
public final class Labels {
	private final Map<String, Integer> labels = new HashMap<>();

	/**
	 * Adds a label with the associated address to the map.
	 *
	 * @param label the label
	 * @param address the address the label refers to
	 */
	public void addLabel(String label, int address) {
		Objects.requireNonNull(label);
		// TODO: Add a check that there are no label duplicates: done
		if(labels.containsKey(label)){
			throw new RuntimeException("Duplicate label found : " +label);
		}
		labels.put(label, address);
	}

	/**
	 * Returns the address associated with the label.
	 *
	 * @param label the label
	 * @return the address the label refers to
	 */
	public int getAddress(String label) {
		// TODO: Where can NullPointerException be thrown here? :done
		//       A null exception is thrown when a null value is passed and assigned to integer,
		//       a null value can't be assigned to integer
		//       in this case if no labels are returned in the argument, program will give NullPointerException
		//       Add code to deal with non-existent labels. :done
		int labelCheck = labels.get(label);
		if(labelCheck == 0){
			throw new NullPointerException("Null label found : "+ label);
		}
		return labels.get(label);
	}

	/**
	 * representation of this instance,
	 * in the form "[label -> address, label -> address, ..., label -> address]"
	 *
	 * @return the string representation of the labels map
	 */
	@Override
	public String toString() {
		// TODO: Implement the method using the Stream API (see also class Registers). :done
		return labels.entrySet().stream()
				.map(e -> e.getKey() + " -> " + e.getValue())
				.collect(Collectors.joining(", ", "[", "]")) ;
	}

	// TODO: Implement equals and hashCode (needed in class Machine). :done


	@Override
	public boolean equals(Object o) {
		if (o instanceof Labels label) {
			return Objects.equals(this.labels, label.labels);
		}
		return false;
	}

	@Override
	public int hashCode() {
		return Objects.hash(labels);
	}

	/**
	 * Removes the labels
	 */
	public void reset() {
		labels.clear();
	}
}
