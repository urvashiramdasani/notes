# Container Orchestration
- To create, scale, and manage large numbers of containers, container orchestration is needed.
- Container orchestration is a process that automates the container lifecycle of a container-based (or “containerized”) applications. 
- This includes deployment, management, scaling, networking, and availability.
- Container orchestration is a necessity in large, dynamic environments, since it: 
    - Streamlines complexity. 
    - Enables hands-off deployment and scaling. 
    - Increases speed, agility, and efficiency. 
    - Seamlessly integrates into CI/CD workflows and DevOps practices. 
    - And allows development teams to use resources more efficiently.
- Container orchestration can be implemented on-premises, and on public, private, or multi-cloud environments.
- “SOAR” requirements - Security, Orchestration, Automation, Response requirements.
- Container orchestration tools have a wide variety of features. These features include: 
    - Defining which container images make up the application, and where they are located (in what registry) 
    - Improving provisioning and deployment of containers for a more automated, unified, and smooth process. 
    - Securing network connections between containers. 
    - Ensuring availability and performance by relocating the containers to another host if an outage or shortage of system resources occurs. 
    - Scaling containers to meet demand, and load balance requests. 
    - Handling resource allocation and scheduling of containers to the underlying infrastructure. 
    - Performing rolling updates and roll backs. 
    - And conducting health checks to ensure applications are running, or performing the necessary actions when checks fail. 
- Container orchestration uses configuration files written in YAML or JSON.
- These files configure each container so it can find resources, establish a network, and store logs. 
- Container orchestration also automatically schedules the deployment of a new container to a cluster, and finds the right host based on predefined settings or restrictions. 
- Additionally, container orchestration manages the container's lifecycle based on specifications in the configuration file. 
- This includes system parameters (like CPU and memory), and file parameters (like proximity and file metadata). 
- And container orchestration supports scaling and enhances productivity, through automation.
- Marathon is a framework for Apache Mesos, an open-source cluster manager that was developed by the University of California at Berkeley. 
- It allows you to scale container infrastructure by automating the bulk of management and monitoring tasks. 
- HashiCorp’s Nomad is a free and open-source cluster management and scheduling tool that supports Docker and other standalone, virtualized, or containerized applications on all major operating systems across all infrastructure, whether on-premises or in the cloud. 
- This flexibility lets teams work with any type and level of workload. 
- Docker Swarm automates the deployment of containerized applications but was designed specifically to work with Docker Engine and other Docker tools making it a popular choice for teams already working in Docker environments. 
- Developed by Google and maintained by the Cloud Native Computing Foundation (CNCF), the open-source platform Kubernetes is the de facto standard for container orchestration. 
- Kubernetes automates a host of container management tasks including deployment, storage provisioning, load balancing and scaling, service discovery, and “self-healing”— the ability to restart, replace or remove a failed container.
- Container orchestration helps to meet business goals and increase profitability by using automation. 
- The benefits of container orchestration for developers and administrators include: 
    - Increased productivity: Removing the burden of individually installing and managing each container, which, in turn reduces errors and frees development teams to focus on application improvement. 
    - Faster deployments: Iteratively releasing new features and capabilities faster and deploying containers and containerized applications rapidly. 
    - Reduced costs: Being cost-effective, service containers have lower overhead and use fewer resources than virtual machines or traditional servers. 
    - Stronger security: Sharing resources and isolating application processes, improving the container’s overall security. 
    - Easier scalability: Scaling applications using a single command. 
    - and faster error recovery: Maintaining high availability by detecting and resolving issues like infrastructure failures automatically.

# Introduction to Kubernetes
- The official Kubernetes documentation describes Kubernetes as “an open-source system for automating deployment, scaling, and management of containerized applications.”
- Kubernetes is an open-source containerization orchestration platform, developed as a project by Google and is currently maintained by the Cloud Native Computing Foundation.
- It is easily portable across clouds and on-premises
- Kubernetes facilitates declarative management in which it automatically performs the necessary operations towards achieving the called for state.

![What Kubernetes is not](<Screenshot 2024-06-25 at 10.12.38 AM.png>)
![Kubernetes Concepts](<Screenshot 2024-06-25 at 10.14.25 AM.png>)
![Kubernetes Concepts](<Screenshot 2024-06-25 at 10.15.11 AM.png>)
![Kubernetes Capabilities](<Screenshot 2024-06-25 at 10.16.48 AM.png>)
![Kubernetes Capabilities](<Screenshot 2024-06-25 at 10.18.21 AM.png>)
![Kubernetes Capabilities](<Screenshot 2024-06-25 at 10.19.45 AM.png>)
![Kubernetes Ecosystem](<Screenshot 2024-06-25 at 10.20.51 AM.png>)
![Kubernetes Ecosystem](<Screenshot 2024-06-25 at 10.22.43 AM.png>)

# Kubernetes Architecture
- A deployment of Kubernetes is called a Kubernetes cluster. 
- A Kubernetes cluster is a cluster of nodes that runs containerized applications. 
- Each cluster has one master node (the Kubernetes Control Plane) and one or more worker nodes. 
- The control plane maintains the intended cluster state by making decisions about the cluster and detecting and responding to events in the cluster.