package com.boil.entity.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;

public class Task {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column task.id
     *
     * @mbg.generated Fri Nov 20 17:52:27 CST 2020
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column task.created_by
     *
     * @mbg.generated Fri Nov 20 17:52:27 CST 2020
     */
    private String createdBy;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column task.created_time
     *
     * @mbg.generated Fri Nov 20 17:52:27 CST 2020
     */
    private LocalDateTime createdTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column task.updated_by
     *
     * @mbg.generated Fri Nov 20 17:52:27 CST 2020
     */
    private String updatedBy;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column task.updated_time
     *
     * @mbg.generated Fri Nov 20 17:52:27 CST 2020
     */
    private LocalDateTime updatedTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column task.untitled
     *
     * @mbg.generated Fri Nov 20 17:52:27 CST 2020
     */
    private String untitled;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column task.receiver_wxid
     *
     * @mbg.generated Fri Nov 20 17:52:27 CST 2020
     */
    private String receiverWxid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column task.name
     *
     * @mbg.generated Fri Nov 20 17:52:27 CST 2020
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column task.content
     *
     * @mbg.generated Fri Nov 20 17:52:27 CST 2020
     */
    private String content;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column task.deadline
     *
     * @mbg.generated Fri Nov 20 17:52:27 CST 2020
     */
    private LocalDate deadline;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column task.status
     *
     * @mbg.generated Fri Nov 20 17:52:27 CST 2020
     */
    private Integer status;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column task.projectcode
     *
     * @mbg.generated Fri Nov 20 17:52:27 CST 2020
     */
    private String projectcode;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column task.id
     *
     * @return the value of task.id
     *
     * @mbg.generated Fri Nov 20 17:52:27 CST 2020
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column task.id
     *
     * @param id the value for task.id
     *
     * @mbg.generated Fri Nov 20 17:52:27 CST 2020
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column task.created_by
     *
     * @return the value of task.created_by
     *
     * @mbg.generated Fri Nov 20 17:52:27 CST 2020
     */
    public String getCreatedBy() {
        return createdBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column task.created_by
     *
     * @param createdBy the value for task.created_by
     *
     * @mbg.generated Fri Nov 20 17:52:27 CST 2020
     */
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy == null ? null : createdBy.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column task.created_time
     *
     * @return the value of task.created_time
     *
     * @mbg.generated Fri Nov 20 17:52:27 CST 2020
     */
    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column task.created_time
     *
     * @param createdTime the value for task.created_time
     *
     * @mbg.generated Fri Nov 20 17:52:27 CST 2020
     */
    public void setCreatedTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column task.updated_by
     *
     * @return the value of task.updated_by
     *
     * @mbg.generated Fri Nov 20 17:52:27 CST 2020
     */
    public String getUpdatedBy() {
        return updatedBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column task.updated_by
     *
     * @param updatedBy the value for task.updated_by
     *
     * @mbg.generated Fri Nov 20 17:52:27 CST 2020
     */
    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy == null ? null : updatedBy.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column task.updated_time
     *
     * @return the value of task.updated_time
     *
     * @mbg.generated Fri Nov 20 17:52:27 CST 2020
     */
    public LocalDateTime getUpdatedTime() {
        return updatedTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column task.updated_time
     *
     * @param updatedTime the value for task.updated_time
     *
     * @mbg.generated Fri Nov 20 17:52:27 CST 2020
     */
    public void setUpdatedTime(LocalDateTime updatedTime) {
        this.updatedTime = updatedTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column task.untitled
     *
     * @return the value of task.untitled
     *
     * @mbg.generated Fri Nov 20 17:52:27 CST 2020
     */
    public String getUntitled() {
        return untitled;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column task.untitled
     *
     * @param untitled the value for task.untitled
     *
     * @mbg.generated Fri Nov 20 17:52:27 CST 2020
     */
    public void setUntitled(String untitled) {
        this.untitled = untitled == null ? null : untitled.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column task.receiver_wxid
     *
     * @return the value of task.receiver_wxid
     *
     * @mbg.generated Fri Nov 20 17:52:27 CST 2020
     */
    public String getReceiverWxid() {
        return receiverWxid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column task.receiver_wxid
     *
     * @param receiverWxid the value for task.receiver_wxid
     *
     * @mbg.generated Fri Nov 20 17:52:27 CST 2020
     */
    public void setReceiverWxid(String receiverWxid) {
        this.receiverWxid = receiverWxid == null ? null : receiverWxid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column task.name
     *
     * @return the value of task.name
     *
     * @mbg.generated Fri Nov 20 17:52:27 CST 2020
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column task.name
     *
     * @param name the value for task.name
     *
     * @mbg.generated Fri Nov 20 17:52:27 CST 2020
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column task.content
     *
     * @return the value of task.content
     *
     * @mbg.generated Fri Nov 20 17:52:27 CST 2020
     */
    public String getContent() {
        return content;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column task.content
     *
     * @param content the value for task.content
     *
     * @mbg.generated Fri Nov 20 17:52:27 CST 2020
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column task.deadline
     *
     * @return the value of task.deadline
     *
     * @mbg.generated Fri Nov 20 17:52:27 CST 2020
     */
    public LocalDate getDeadline() {
        return deadline;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column task.deadline
     *
     * @param deadline the value for task.deadline
     *
     * @mbg.generated Fri Nov 20 17:52:27 CST 2020
     */
    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column task.status
     *
     * @return the value of task.status
     *
     * @mbg.generated Fri Nov 20 17:52:27 CST 2020
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column task.status
     *
     * @param status the value for task.status
     *
     * @mbg.generated Fri Nov 20 17:52:27 CST 2020
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column task.projectcode
     *
     * @return the value of task.projectcode
     *
     * @mbg.generated Fri Nov 20 17:52:27 CST 2020
     */
    public String getProjectcode() {
        return projectcode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column task.projectcode
     *
     * @param projectcode the value for task.projectcode
     *
     * @mbg.generated Fri Nov 20 17:52:27 CST 2020
     */
    public void setProjectcode(String projectcode) {
        this.projectcode = projectcode == null ? null : projectcode.trim();
    }

    /**
     * This enum was generated by MyBatis Generator.
     * This enum corresponds to the database table task
     *
     * @mbg.generated Fri Nov 20 17:52:27 CST 2020
     */
    public enum Column {
        id("id", "id", "INTEGER", false),
        createdBy("created_by", "createdBy", "VARCHAR", false),
        createdTime("created_time", "createdTime", "TIMESTAMP", false),
        updatedBy("updated_by", "updatedBy", "VARCHAR", false),
        updatedTime("updated_time", "updatedTime", "TIMESTAMP", false),
        untitled("untitled", "untitled", "VARCHAR", false),
        receiverWxid("receiver_wxid", "receiverWxid", "VARCHAR", false),
        name("name", "name", "VARCHAR", false),
        content("content", "content", "VARCHAR", false),
        deadline("deadline", "deadline", "DATE", false),
        status("status", "status", "INTEGER", false),
        projectcode("projectcode", "projectcode", "VARCHAR", false);

        /**
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database table task
         *
         * @mbg.generated Fri Nov 20 17:52:27 CST 2020
         */
        private static final String BEGINNING_DELIMITER = "\"";

        /**
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database table task
         *
         * @mbg.generated Fri Nov 20 17:52:27 CST 2020
         */
        private static final String ENDING_DELIMITER = "\"";

        /**
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database table task
         *
         * @mbg.generated Fri Nov 20 17:52:27 CST 2020
         */
        private final String column;

        /**
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database table task
         *
         * @mbg.generated Fri Nov 20 17:52:27 CST 2020
         */
        private final boolean isColumnNameDelimited;

        /**
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database table task
         *
         * @mbg.generated Fri Nov 20 17:52:27 CST 2020
         */
        private final String javaProperty;

        /**
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database table task
         *
         * @mbg.generated Fri Nov 20 17:52:27 CST 2020
         */
        private final String jdbcType;

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table task
         *
         * @mbg.generated Fri Nov 20 17:52:27 CST 2020
         */
        public String value() {
            return this.column;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table task
         *
         * @mbg.generated Fri Nov 20 17:52:27 CST 2020
         */
        public String getValue() {
            return this.column;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table task
         *
         * @mbg.generated Fri Nov 20 17:52:27 CST 2020
         */
        public String getJavaProperty() {
            return this.javaProperty;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table task
         *
         * @mbg.generated Fri Nov 20 17:52:27 CST 2020
         */
        public String getJdbcType() {
            return this.jdbcType;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table task
         *
         * @mbg.generated Fri Nov 20 17:52:27 CST 2020
         */
        Column(String column, String javaProperty, String jdbcType, boolean isColumnNameDelimited) {
            this.column = column;
            this.javaProperty = javaProperty;
            this.jdbcType = jdbcType;
            this.isColumnNameDelimited = isColumnNameDelimited;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table task
         *
         * @mbg.generated Fri Nov 20 17:52:27 CST 2020
         */
        public String desc() {
            return this.getEscapedColumnName() + " DESC";
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table task
         *
         * @mbg.generated Fri Nov 20 17:52:27 CST 2020
         */
        public String asc() {
            return this.getEscapedColumnName() + " ASC";
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table task
         *
         * @mbg.generated Fri Nov 20 17:52:27 CST 2020
         */
        public static Column[] excludes(Column ... excludes) {
            ArrayList<Column> columns = new ArrayList<>(Arrays.asList(Column.values()));
            if (excludes != null && excludes.length > 0) {
                columns.removeAll(new ArrayList<>(Arrays.asList(excludes)));
            }
            return columns.toArray(new Column[]{});
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table task
         *
         * @mbg.generated Fri Nov 20 17:52:27 CST 2020
         */
        public String getEscapedColumnName() {
            if (this.isColumnNameDelimited) {
                return new StringBuilder().append(BEGINNING_DELIMITER).append(this.column).append(ENDING_DELIMITER).toString();
            } else {
                return this.column;
            }
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table task
         *
         * @mbg.generated Fri Nov 20 17:52:27 CST 2020
         */
        public String getAliasedEscapedColumnName() {
            return this.getEscapedColumnName();
        }
    }
}