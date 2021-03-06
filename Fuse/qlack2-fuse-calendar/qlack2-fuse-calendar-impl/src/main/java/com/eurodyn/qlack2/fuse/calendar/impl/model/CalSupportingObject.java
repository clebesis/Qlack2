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
package com.eurodyn.qlack2.fuse.calendar.impl.model;
// Generated by Hibernate Tools 3.2.4.GA

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * CalSupportingObject generated by hbm2java
 */
@Entity
@Table(name="cal_supporting_object"
)
public class CalSupportingObject  implements java.io.Serializable {


     private String id;
     private CalItem itemId;
     private String supportingObjectCategoryId;
     private String objectId;
     private String link;
     private String filename;
     private String mimetype;
     private byte[] objectData;
     private long createdOn;
     private String createdBy;
     private long lastModifiedOn;
     private String lastModifiedBy;

    public CalSupportingObject() {
    }


    public CalSupportingObject(CalItem itemId, String supportingObjectCategoryId, long createdOn, String createdBy, long lastModifiedOn, String lastModifiedBy) {
        this.itemId = itemId;
        this.supportingObjectCategoryId = supportingObjectCategoryId;
        this.createdOn = createdOn;
        this.createdBy = createdBy;
        this.lastModifiedOn = lastModifiedOn;
        this.lastModifiedBy = lastModifiedBy;
    }
    public CalSupportingObject(CalItem itemId, String supportingObjectCategoryId, String objectId, String link, String filename, String mimetype, byte[] objectData, long createdOn, String createdBy, long lastModifiedOn, String lastModifiedBy) {
       this.itemId = itemId;
       this.supportingObjectCategoryId = supportingObjectCategoryId;
       this.objectId = objectId;
       this.link = link;
       this.filename = filename;
       this.mimetype = mimetype;
       this.objectData = objectData;
       this.createdOn = createdOn;
       this.createdBy = createdBy;
       this.lastModifiedOn = lastModifiedOn;
       this.lastModifiedBy = lastModifiedBy;
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
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="item_id", nullable=false)
		public CalItem getItemId() {
			return this.itemId;
		}

    public void setItemId(CalItem itemId) {
        this.itemId = itemId;
    }

    @Column(name="supporting_object_category_id", nullable=false, length=36)
		public String getSupportingObjectCategoryId() {
			return this.supportingObjectCategoryId;
		}

    public void setSupportingObjectCategoryId(String supportingObjectCategoryId) {
        this.supportingObjectCategoryId = supportingObjectCategoryId;
    }

    @Column(name="object_id", length=36)
		public String getObjectId() {
			return this.objectId;
		}

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    @Column(name="link", length=1024)
		public String getLink() {
			return this.link;
		}

    public void setLink(String link) {
        this.link = link;
    }

    @Column(name="filename", length=256)
		public String getFilename() {
			return this.filename;
		}

    public void setFilename(String filename) {
        this.filename = filename;
    }

    @Column(name="mimetype")
		public String getMimetype() {
			return this.mimetype;
		}

    public void setMimetype(String mimetype) {
        this.mimetype = mimetype;
    }

    @Column(name="object_data")
		public byte[] getObjectData() {
			return this.objectData;
		}

    public void setObjectData(byte[] objectData) {
        this.objectData = objectData;
    }

    @Column(name="created_on", nullable=false)
		public long getCreatedOn() {
			return this.createdOn;
		}

    public void setCreatedOn(long createdOn) {
        this.createdOn = createdOn;
    }

    @Column(name="created_by", nullable=false, length=36)
		public String getCreatedBy() {
			return this.createdBy;
		}

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    @Column(name="last_modified_on", nullable=false)
		public long getLastModifiedOn() {
			return this.lastModifiedOn;
		}

    public void setLastModifiedOn(long lastModifiedOn) {
        this.lastModifiedOn = lastModifiedOn;
    }

    @Column(name="last_modified_by", nullable=false, length=36)
		public String getLastModifiedBy() {
			return this.lastModifiedBy;
		}

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }




}


