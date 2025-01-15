# The many different aspects of Data Governance
- **Data governance** is the various things an organization needs to do to ensure the secure, compliant and effective use of data, from the time the data is created through to when it is archived or deleted. 
- This includes processes that make the data discoverable, understandable, and usable, while ensuring that the data is of high quality, and that data is protected and secured.
- **Data security** dictates how an organization should protect data to ensure that data is stored securely (such as in an encrypted state), and that access by unauthorized entities is prevented. 
- For example, all the things an organization does to prevent falling victim to a ransomware attack, or having their data stolen and sold on the dark web, falls under data security.
- **Responsible handling of data** involves making sure that only people that need access to specific datasets have that access (such as ensuring that data is not just generally open to all users of a system without considering whether they need access to that data to perform their job). 
- Responsible handling also means ensuring that an organization only uses and processes data on individuals in approved ways, and that organizations provide data disclosures as required by law.

# Data security, access and privacy
## Core data protection concepts
### Personally Identifiable Information (PII)
- Personally identifiable information (PII) is a term commonly used in North America to reference any information that can be used to identify an individual. 
- This can refer to either the information on its own being able to identify an individual or where the information can be combined with other linkable information to identify an individual. 
- It includes information such as full name, social security number, IP address, and photos or videos.
- PII also covers data that provides information about a specific aspect of an individual (such as a medical condition, location, or political affiliation).

### Personal Data
- Personal data is a term that is defined in GDPR and is considered to be similar to, but broader than, the definition of PII.

### Encryption
- Encryption is a mathematical technique of encoding data using a key in such a way that the data becomes unrecognizable and unusable. 
- An authorized user who has the key used to encrypt the data can use the key to decrypt the data and return it to its original plaintext form.
- Encryption in transit: This is the process of encrypting data as it moves between systems. 

    For example, a system that migrates data from a database to a data lake should ensure that the data is encrypted before being transmitted, that the source and target endpoints are authenticated, and the data can then be decrypted at the target for processing. 
    
    This helps ensure that if someone can intercept the data stream during transmission, that the data is encrypted and therefore unable to be read and used by the person who intercepted the data. 
    
    A common way to achieve this is to use the **Transport Layer Security (TLS)** protocol for all communications between systems.
- Encryption at rest: This is the encryption of data that is written to a storage medium, such as a disk. 

    After each phase of data processing, all the data that is persisted to disk should be encrypted.

### Anonymized Data
- Anonymized data is data that has been altered in such a way that personal data is irreversibly de-identified, rendering it impossible for any PII data to be identified. 
- For example, this could involve replacing PII data with randomly generated data, in such a way that the randomization cannot be reversed to recreate the original data.
- Another way anonymization can be applied is to remove most of the PII data so that only a few attributes that may be considered PII remains, but with enough PII data removed to make it difficult to identify an individual. 
- However, this contains risk, as it is often still possible to identify an individual even with only minimal data.

### Pseudonymized data / tokenization
- While this is similar to the concept of anonymized data, the big difference is that with pseudonymized data, the original PII data can still be accessed.
- Pseudonymized data is defined by GDPR as data that cannot be attributed to a specific data subject without the use of separately kept "additional information."
- There are multiple techniques for creating pseudonymized data. 
- For example, you can replace a full name with a randomly generated token, a different name (so that it looks real but is not), a hash representing the name, and more.
- For example, when a raw dataset is ingested into the data lake, the first step may be to pass the data through the tokenization system. 
- This system will replace all PII data in the dataset with an anonymous token, and will record each real_data token substitution in a secure database. 
- Once the data has been transformed, if a data consumer requires access and is authorized to access the PII data, they can pass the dataset to the tokenization system to be detokenized (that is, have the tokens replaced with the original, real values).
- The benefit of a tokenization system is that the generated token is random and does not contain any reference to the original value, and there is no way to determine the original value just from the token. 
- If there is a data breach that can steal a dataset with tokenized data, there is no way to perform reverse engineering on the token to find the original value.
- However, the tokenization system itself contains all the PII data, along with the associated tokens. 
- If an entity can access the tokenized data and is also able to comprise the tokenization system, they will have access to all PII data. 
- Therefore, it is important that the tokenization system is completely separate from the analytic systems containing the tokenized data, and that the tokenization system is protected properly.
- **Hashing** is generally considered the least secure method of de-identifying PII data, especially when it comes to data types with a limited set of values, such as social security numbers and names.
- Hashing uses several popular hashing algorithms to create a hash of an original value. 
- An original value, such as the name "John Smith," will always return the same hash value for a specific algorithm.
- However, all possible social security numbers and most names have been passed through popular hashing algorithms and lookup tables have been created, known as **rainbow tables**. 
- Using these rainbow tables, anyone can take a hashed name or social security number and quickly identify the original value.

### Authentication
- Authentication is the process of validating that a claimed identity is that identity.
- **Federated identity** is a concept related to authentication and means that responsibility for authenticating a user is done by another system. 
- For example, when logging in to the AWS Management Console, your administrator could set up a federated identity so that you use your Active Directory credentials to log in via your organization's access portal, and the organization's Active Directory server authenticates you. 
- Once authenticated, the Active Directory server confirms to the AWS Management Console that you have been successfully authenticated as a specific user. 
- This means you do not need a separate username and password to log in to the AWS system, but that you can use your existing Active Directory credentials to be authenticated to an identity in AWS.

### Authorization
- Authorization is the process of authorizing access to a resource based on a validated identity.
- A data lake administrator can, for example, authorize you to access data that is in the Conformed Zone of the data lake, but not grant you access to data in the Raw Zone.

# Data quality, data profiling, and data lineage
## Data Quality
- Common ways in which data quality can be measured: Accuracy, Completeness, Consistency, Timeliness

## Data Profiling
- Data profiling is the process of analyzing a dataset, and then reporting on various aspects of the data content. 
- This is useful to give both data engineers, and other potential users of the data, better insight into the underlying data. 
- Data profiling can also be very useful to quickly identify potential data quality issues in a dataset.
- Various aspects of the report for each column could be: Missing Values, Distinct Values, Unique Values, Minimum / Maximum String Length or Minimum Maximum Value.
- Data profiling does not make any assessment about the quality of data, but rather just reports on the profile, or shape, of the data.

## Data Lineage
- Data lineage allows a user to view information about the original sources of a dataset, as well the transformations that have been applied to those sources.
- When a data analyst is searching for a dataset, being able to view the data lineage that shows how that table was created, helps to build trust that the table is appropriate for their use case.
- The results of data quality checks, information on the data profile, and a visualization of data lineage, can all be recorded in a data catalog, enabling users to search for datasets and dig deeper into information about that dataset.

# Business and technical data catalogs
## Implementing a data catalog to avoid creating a data swamp
- A central data catalog that can be used to keep a searchable record of all the datasets in the data lake
- Policies that ensure useful metadata is added to all the entries in the data catalog, and policies for ensuring that only high-quality data is allowed to be added to the data catalog
- When we talk about a central catalog, we are generally referring to a business data catalog, and the business catalog is usually associated with one or more technical catalogs.