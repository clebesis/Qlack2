/*
* Copyright 2014 EUROPEAN DYNAMICS SA <info@eurodyn.com>
*
* Licensed under the EUPL, Version 1.1 only (the "License").
* You may not use this work except in compliance with the Licence.
* You may obtain a copy of the Licence at:
* https://joinup.ec.europa.eu/software/page/eupl/licence-eupl
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the Licence is distributed on an "AS IS" basis,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the Licence for the specific language governing permissions and
* limitations under the Licence.
*/
package com.eurodyn.qlack2.fuse.simm.impl.model;
// Generated by Hibernate Tools 3.2.4.GA

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * SimGroup generated by hbm2java
 */
@Entity
@Table(name = "sim_group")
public class SimGroup implements java.io.Serializable {

	private String id;
	private SimGroup parentGroupId;
	private String name;
	private String slugify;
	private byte[] logo;
	private String description;
	private Byte privacy;
	private String tags;
	private byte status;
	private long createdOn;
	private Set<SimGroupHasUser> simGroupHasUsers = new HashSet<SimGroupHasUser>(0);
	private Set<SimGroup> simGroups = new HashSet<SimGroup>(0);
	private List<SimGroupAttribute> simGroupAttributes;

	public SimGroup() {
	}

	public SimGroup(String name, byte status, long createdOn) {
		this.name = name;
		this.status = status;
		this.createdOn = createdOn;
	}

	public SimGroup(SimGroup parentGroupId, String name, byte[] logo, String description, Byte privacy, String tags,
			byte status, long createdOn, Set<SimGroupHasUser> simGroupHasUsers, Set<SimGroup> simGroups) {
		this.parentGroupId = parentGroupId;
		this.name = name;
		this.logo = logo;
		this.description = description;
		this.privacy = privacy;
		this.tags = tags;
		this.status = status;
		this.createdOn = createdOn;
		this.simGroupHasUsers = simGroupHasUsers;
		this.simGroups = simGroups;
	}

	@Id
	public String getId() {
		if (this.id == null) {
			this.id = java.util.UUID.randomUUID().toString();
		}

		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "parent_group_id")
	public SimGroup getParentGroupId() {
		return this.parentGroupId;
	}

	public void setParentGroupId(SimGroup parentGroupId) {
		this.parentGroupId = parentGroupId;
	}

	@Column(name = "name", nullable = false, length = 256)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "slygify", length = 256)
	public String getSlugify() {
		return slugify;
	}

	public void setSlugify(String slugify) {
		this.slugify = slugify;
	}

	@Column(name = "logo")
	public byte[] getLogo() {
		return this.logo;
	}

	public void setLogo(byte[] logo) {
		this.logo = logo;
	}

	@Column(name = "description", length = 65535)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "privacy")
	public Byte getPrivacy() {
		return this.privacy;
	}

	public void setPrivacy(Byte privacy) {
		this.privacy = privacy;
	}

	@Column(name = "tags", length = 65535)
	public String getTags() {
		return this.tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	@Column(name = "status", nullable = false)
	public byte getStatus() {
		return this.status;
	}

	public void setStatus(byte status) {
		this.status = status;
	}

	@Column(name = "created_on", nullable = false)
	public long getCreatedOn() {
		return this.createdOn;
	}

	public void setCreatedOn(long createdOn) {
		this.createdOn = createdOn;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "groupId")
	public Set<SimGroupHasUser> getSimGroupHasUsers() {
		return this.simGroupHasUsers;
	}

	public void setSimGroupHasUsers(Set<SimGroupHasUser> simGroupHasUsers) {
		this.simGroupHasUsers = simGroupHasUsers;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "parentGroupId")
	public Set<SimGroup> getSimGroups() {
		return this.simGroups;
	}

	public void setSimGroups(Set<SimGroup> simGroups) {
		this.simGroups = simGroups;
	}

	/**
	 * @return the simGroupAttributes
	 */
	// bi-directional many-to-one association to SimGroupAttribute
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "group")
	public List<SimGroupAttribute> getSimGroupAttributes() {
		return simGroupAttributes;
	}

	/**
	 * @param simGroupAttributes
	 *            the simGroupAttributes to set
	 */
	public void setSimGroupAttributes(List<SimGroupAttribute> simGroupAttributes) {
		this.simGroupAttributes = simGroupAttributes;
	}

	public static SimGroup find(String groupId, EntityManager em) {
		return em.find(SimGroup.class, groupId);
	}
}
