# Introduction to Containers

- Containers solve the problem of making software portable so that applications can run on multiple platforms.
- A container, powered by the containerization engine, is a standard unit of software that encapsulates the application code, runtime, system tools, system libraries, and settings necessary for programmers to build, ship, and run applications efficiently.

![Why Use Containers?](<Screenshot 2024-06-10 at 3.22.39 PM.png>)

- Operations and underlying infrastructure issues are no longer blockers. 
- You can quickly move applications from your laptop to a testing environment, from a staging environment to a production environment, from a physical machine to a virtual machine, or a private cloud or public cloud, and always know that your application will work correctly. 
- A container can be small, just tens of megabytes, and developers can almost instantly start containerized applications.

![Container Characteristics](<Screenshot 2024-06-10 at 3.24.16 PM.png>)

- Docker is a robust platform and the most popular container platform today. 
- Podman is a daemon-less container engine that is more secure than Docker. 
- Developers often prefer LXC for data-intensive applications and operations. 
- Vagrant offers the highest levels of isolation on the running physical machine.


# Introduction to Docker
- Docker became popular with developers because of its simple architecture, massive scalability, and portability on multiple platforms, environments, and locations. 
- Docker isolates applications from infrastructure, including the hardware, the operating system, and the container runtime. 
- Docker is written in the Go programming language. 
- Docker uses Linux kernel features to deliver its functionality. 
- Docker also uses namespaces to provide an isolated workspace called the container. 
- Docker creates a set of namespaces for every container and each aspect runs in a separate namespace with access limited to that namespace.
- Docker methodology has inspired additional innovations, including: Complementary tools such as Docker CLI, Docker Compose, and Prometheus, and various plugins, including storage plugins; orchestration technologies using Docker Swarm or Kubernetes; and development methodologies using microservices and serverless. 
- Docker offers the following benefits: 
    - Docker’s consistent and isolated environments result in stable application deployments. 
    - Deployments occur in seconds. 
    - Because Docker images are small and reusable, they significantly speed up the development process. 
    - Docker automation capabilities help eliminate errors, simplifying the maintenance cycle. 
    - Docker supports Agile and CI/CD DevOps practices. 
    - Docker’s easy versioning speeds up testing, rollbacks, and redeployments. 
    - Docker helps segment applications for easy refresh, cleanup, and repair. 
    - Developers collaborate to resolve issues faster and scale containers when needed.
    - Docker images are platform-independent, so they are highly portable. 
    
- Docker is not a good fit for applications with these qualities: 
    - Require high performance or security
    - Are based on Monolith architecture
    - Use rich GUI features
    - Perform standard desktop or limited functions.

## Building and Running Container Images
![Docker Container Creation Process](<Screenshot 2024-06-10 at 7.46.10 PM.png>)
![Docker Build Command](<Screenshot 2024-06-10 at 7.47.20 PM.png>)
![Docker Image Verification](<Screenshot 2024-06-10 at 7.47.49 PM.png>)
![Docker Commands](<Screenshot 2024-06-10 at 7.49.48 PM.png>)

## Docker Objects
- Docker contains objects such as Dockerfile, images, container, network, storage volumes, and other objects, such as plugins and add-ons. 
- A Dockerfile is a text file that contains instructions needed to create an image. You can create a Dockerfile using any editor from the console or terminal.
- A Dockerfile must always begin with a FROM instruction that defines a base image. 
- Often the base image is from a public repository, like an operating system or a specific language like Go or Node.js. 
- The RUN instruction executes commands. 
- The CMD instruction defines a default command for execution. 
- A Dockerfile should have only one CMD instruction. 
- If the Dockerfile has several CMD instructions, only the last CMD instruction will take effect.
- A Docker Image is a read-only template with instructions for creating a Docker container. - The Dockerfile provides instructions to build the image, and Each Docker instruction creates a new layer in the image. 
- When you change the Dockerfile and rebuild the image, the Docker engine only rebuilds the changed layers. 
- Images can share these layers, which saves a lot of disk space as well as network bandwidth when sending and receiving images. 
- When you instantiate this image, you get a running container. 
- At this point, a writeable container layer is placed on top of the read-only layers, and The writeable layer is needed because containers are not immutable as images.
- An image name has a unique format that consists of three parts: the hostname, the repository, and the tag. 
- The hostname identifies the image registry. 
- A repository is a group of related container images. 
- And the tag provides information about a specific version or variant of an image.

![Container Image Naming](<Screenshot 2024-06-10 at 8.13.37 PM.png>)

- A Docker container is a runnable instance of an image. 
- You can use the Docker API or CLI to create, start, stop, or delete an image. 
- You can connect to multiple networks, attach storage to the container, or create a new image based on its current state. 
- Docker keeps containers well isolated from each other and their host machine. 
- When using Docker, networks help isolate container communications. 
- By default, data doesn’t persist when the container no longer exists. 
- Docker uses volumes and bind mounts to persist data even after a container stops. 
- And plugins, such as storage plugins, provide the ability to connect to external storage platforms.

## Docker Architecture
- The Docker client-server architecture provides a complete application environment. 
- Docker components include the client, the host, and the registry
- First, you’ll use either the Docker command line interface or REST APIs via the Docker client to send instructions to the Docker host server, commonly called the host. 
- The Docker host contains the daemon, known as dockerd. 
- The daemon listens for Docker API requests or commands such as “docker run” and processes those commands. 
- The daemon does the heavy lifting to build, run, and distribute Docker containers. 
- Then, Docker stores the container images in a registry. 
- The Docker host also includes and manages: Images Containers Namespaces Networks Storage Plugins and add-ons. 
- You can use the Docker ​ client to communicate with local ​ and remote Docker hosts. 
- You can run the Docker client and daemon on the same system or​ connect your Docker client to a remote Docker daemon.​ 
- And Docker daemons can also communicate with other daemons to manage Docker services. 
- Docker stores and distributes images in a registry. 
- Registry access is either public, such as Docker Hub, which is accessible by everyone, or private.
- Registry locations are hosted using a third-party provider, such as IBM Cloud Container Registry, or self-hosted in private data centers or on the cloud.
- First, developers build and push the images using automation or a build pipeline into a registry, where Docker stores these images. 
- Then, local machines, cloud systems, and on-premises systems can pull those images.

![Registry Access](<Screenshot 2024-06-10 at 9.18.33 PM.png>)
![Docker Architecture](<Screenshot 2024-06-10 at 9.19.48 PM.png>)
![Docker CLI](<Screenshot 2024-06-10 at 9.41.36 PM.png>)
![Container Basics](<Screenshot 2024-06-10 at 9.43.07 PM.png>)
