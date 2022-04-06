package dev.mfaydali.data;

import dev.mfaydali.models.Status;

public interface StatusDAO extends GenericDAO<Status> {

	public boolean createStatusMessage(Status stat);

	public Status getStatusMessage(int statusId);

	public boolean deleteStatusMessage(int statusId);


}
