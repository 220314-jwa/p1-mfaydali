package dev.mfaydali.models;

import java.util.Date;
import java.util.Objects;

public class Request {
	private int requestId;
	private int submitterId;
	private int eventId;
	private int statusId;
	private Date eventDate;
	private int cost;
	private String description;
	private String location;
	private Date submittedAt;

	// Constructor


	public Request(int i) {
		this.requestId = 0;
		this.submitterId = 0;
		this.eventId = 0;
		this.statusId = 0;
		this.eventDate = new Date();
		this.cost = 0;
		this.description = "";
		this.location = "";
		this.submittedAt = new Date();
	}




	public Request() {
		this.requestId = requestId;
		this.submitterId = submitterId;
		this.eventId = eventId;
		this.statusId = statusId;
		this.eventDate = eventDate;
		this.cost = cost;
		this.description = description;
		this.location = location;
		this.submittedAt = submittedAt;
	}







	// Getters and Setters
	public int getRequestId() {
		return requestId;
	}

	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}

	public int getSubmitterId() {
		return submitterId;
	}

	public void setSubmitterId(int submitterId) {
		this.submitterId = submitterId;
	}

	public int getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	public int getStatusId() {
		return statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}

	public Date getEventDate() {
		return eventDate;
	}

	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Date getSubmittedAt() {
		return submittedAt;
	}

	public void setSubmittedAt(Date submittedAt) {
		this.submittedAt = submittedAt;
	}

	@Override
	public String toString() {
		return "Request [requestId=" + requestId + ", submitterId=" + submitterId + ", eventId=" + eventId
				+ ", statusId=" + statusId + ", eventDate=" + eventDate + ", cost=" + cost + ", description="
				+ description + ", location=" + location + ", submittedAt=" + submittedAt + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(cost, description, eventDate, eventId, location, requestId, statusId, submittedAt,
				submitterId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Request other = (Request) obj;
		return cost == other.cost && Objects.equals(description, other.description)
				&& Objects.equals(eventDate, other.eventDate) && eventId == other.eventId
				&& Objects.equals(location, other.location) && requestId == other.requestId
				&& statusId == other.statusId && Objects.equals(submittedAt, other.submittedAt)
				&& submitterId == other.submitterId;
	}


}
