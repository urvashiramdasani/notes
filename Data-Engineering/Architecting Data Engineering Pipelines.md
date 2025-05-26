- A data pipeline is the process that ingests data from multiple sources, optimizes and transforms the data, and makes it available to data consumers.

## Approaching the data pipeline architecture

- Gather information from project sponsors and data consumers on their requirements. Learn what their objectives are, what types of tools they want to use to consume the data, required data transformations, and so on.
- Gather information on the available data sources. This may include what systems store the raw data, what format that data is in, who the system and data owner are, and so on.
- Determine what types of tools are available and may be best suited for these requirements.

A useful way to gather this information is to conduct a whiteboarding session with the relevant stakeholders.

![[Pasted image 20250526201230.jpg]]

- Details about the source system containing the data (is the data in a database, in files on a server, existing files on Amazon S3, coming from a streaming source, and so on)?
- If this data is internal data, who is the owner of the source system within the business? Who is the owner of the data?
- What frequency does the data need to be ingested on (continuous streaming/replication, loading data every few hours, loading data once a day)?
- Optionally, discuss some potential tools that could be used for data ingestion.
- What is the raw/ingested format of the data (CSV, JSON, native database format, and so on)?
- Does the data source contain PII or other types of data that is subject to governance controls? If so, what controls need to be put in place to protect the data?

## Identifying data transformations and optimizations
### File format optimizations
- CSV, XML, JSON, and other types of plaintext files are commonly used to store structured and semi-structured data. 
- These file formats are useful when manually exploring data, but there are much better, binary-based file formats to use for computer-based analytics. 
- A common binary format that is optimized for read-heavy analytics is the Apache Parquet format. 
- A common transformation is to convert plaintext files into an optimized format, such as Apache Parquet.

### Data standardisation 
- When building out a pipeline, we often load data from multiple different data sources, and each of those data sources may have different naming conventions for referring to the same item. 
- For example, a field containing someone's birth date may be called DOB, dateOfBirth, birth_date, and so on. 
- The format of the birth date may also be stored as mm/dd/yy, dd/mm/yyyy, or in a multitude of other formats.
- One of the tasks we may want to do when optimizing data for analytics is to standardize column names, types, and formats.
- By having a corporate-wide analytic program, standard definitions can be created and adopted across all analytic projects in the organization.

### Data quality checks

### Data partitioning 
- A common optimization strategy for analytics is to partition the data, grouping the data at the physical storage layer by a field that is often used in queries. 
- For example, if data is often queried by a date range, then data can be partitioned by a date field. 
- If storing sales data, for example, all the sales transactions for a specific month would be stored in the same Amazon S3 prefix (which is much like a directory). 
- When a query is run that selects all the data for a specific day, the analytic engine only needs to read the data in the directory that's storing data for the relevant month.

### Data denormalisation
- In traditional relational database systems, the data is normalized, meaning that each table contains information on a specific focused topic, and associated, or related, information is contained in a separate table. 
- The tables can then be linked through the use of foreign keys.
- For data lakes, combining the data from multiple tables into a single table can often improve query performance. 
- Data denormalization takes two (or more) tables and creates a new table with data from both tables.

### Data cataloging


- Is there an existing set of standardized column name definitions and formats that can be referenced? If not, who will be responsible for creating these standard definitions?
- What additional business metadata should be captured for datasets? For example, data owner, column descriptions, cost allocation tags, data sensitivity, and so on.
- What format should optimized files be stored in? Apache Parquet is a common format, but you need to validate that the tools used by the data consumers can work with files in Apache Parquet format.
- Is there an obvious field that the data should be partitioned by?
- Are other required data transformations obvious at this point? For example, if you're ingesting data from a relational database, should the data be denormalized?
- What data transformation engines/skills does the team have? For example, does the team have experience creating Spark jobs using PySpark?

![[Pasted image 20250526201257.jpg]]

## Loading data into data marts
- there are times where a use case may require much lower latency, higher performance reads of the data. 
- Or, there may be times where the use of highly structured schemas may best meet the analytic requirements of the use case. 
- In these cases, loading data from the data lake into a data mart makes sense.
- In analytic environments, a data mart is most often a data warehouse system (such as Amazon Redshift, or Snowflake), but it could also be a relational database system (such as Amazon RDS MySQL), depending on the use case's requirements. 
- In either case, the system will have local storage (often high-speed flash drives) and local compute power, offering the best performance when needing to query across large datasets, and specifically where queries require joining across many tables.