package eu.excitementproject.eop.distsim.items;

import java.util.HashSet;
import java.util.Set;


/**
 * Instantiation of {@link DefaultTextUnit} with a state of type string
 * 
 * Thread-safe
 * @author Meni Adler
 * @since 20/06/2012
 * 
 */
public class StringBasedTextUnit extends DeafaultTextUnit<String> {

	private static final long serialVersionUID = 1L;


	public StringBasedTextUnit(String data) {
		super(data);
	}

	public StringBasedTextUnit(String data, long count) {
		super(data,count);
	}
	
	public StringBasedTextUnit(String data, int id, long count) {
		super(data, id,count);
	}
	
	public TextUnit copy() {
		return new StringBasedTextUnit(data, id,(long)count);
	}
	
	
	/* (non-Javadoc)
	 * @see org.excitement.distsim.items.KeyExternalizable#toKey()
	 */
	@Override
	public String toKey() {
		return data;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		sb.append(data);
		sb.append(",");
		sb.append(id);
		sb.append(",");
		sb.append(count);
		sb.append(">");
		return sb.toString();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return toKey().hashCode();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Externalizable other = (Externalizable) obj;
		try {
			return toKey().equals(other.toKey());
		} catch (UndefinedKeyException e) {
			return false;
		}
	}
	
	/* (non-Javadoc)
	 * @see eu.excitementproject.eop.distsim.items.Externalizable#toKeys()
	 */
	@Override
	public Set<String> toKeys() throws UndefinedKeyException {
		Set<String> ret = new HashSet<String>();
		ret.add(toKey());
		return ret;
	}

	/* (non-Javadoc)
	 * @see eu.excitementproject.eop.distsim.items.Externalizable#fromKey(java.lang.String)
	 */
	
	@Override
	public void fromKey(String key) throws UndefinedKeyException {
		data = key;
	}
}

