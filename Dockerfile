FROM jenkins/jenkins:lts

# Cambiar a root para instalar paquetes y configurar permisos
USER root

# Instalar Docker y dependencias necesarias
RUN apt-get update && \
    apt-get install -y docker.io && \
    apt-get clean && \
    rm -rf /var/lib/apt/lists/*

# Crear grupo docker si no existe y agregar el usuario jenkins a ese grupo
RUN groupadd -for docker && usermod -aG docker jenkins

# Volver a usuario jenkins
USER jenkins
