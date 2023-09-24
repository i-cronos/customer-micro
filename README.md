# Project creation
***

## Create from console

> * mvn archetype:generate -DgroupId=pe.ibk.cpe -DartifactId=customer-micro
>    * mvn archetype:generate -DgroupId=pe.ibk.cpe -DartifactId=customer-application
>    * mvn archetype:generate -DgroupId=pe.ibk.cpe -DartifactId=customer-container
>    * mvn archetype:generate -DgroupId=pe.ibk.cpe -DartifactId=customer-domain
>        * mvn archetype:generate -DgroupId=pe.ibk.cpe -DartifactId=customer-domain-core
>        * mvn archetype:generate -DgroupId=pe.ibk.cpe -DartifactId=customer-domain-service
>    * mvn archetype:generate -DgroupId=pe.ibk.cpe -DartifactId=customer-infrastructure
>        * mvn archetype:generate -DgroupId=pe.ibk.cpe -DartifactId=customer-infrastructure-database
>        * mvn archetype:generate -DgroupId=pe.ibk.cpe -DartifactId=customer-infrastructure-rest
>        * mvn archetype:generate -DgroupId=pe.ibk.cpe -DartifactId=customer-infrastructure-email
>        * mvn archetype:generate -DgroupId=pe.ibk.cpe -DartifactId=customer-infrastructure-sftp

## Example
***
### Get project info
> ` curl -XGET http://localhost:8080/api/v1/info -H "Accept-Type: application/json" `

### Register a customer

> ` curl -XPOST http://localhost:8080/api/v1/customer -H "Content-Type: application/json" -H "Accept-Type: application/json" -d '{"societyType":"SA","businessName":"ACME","document":{"documentType":"RUC","documentNumber":"20111222333"},"address":{"streetName":"Jr. Las flores","streetNumber":"128"},"contact":{"phone":{"phoneOperator":"CLARO","phoneNumber":"999777555"},"email":{"type":"PERSONAL","email":"acme@gmail.com"}},"shareholders":[{"firstName":"Juanito","lastName":"Flores","document":{"documentType":"DNI","documentNumber":"22224444"},"percentage":60},{"firstName":"Benito","lastName":"Flower","document":{"documentType":"DNI","documentNumber":"33335555"},"percentage":40}]}' `

