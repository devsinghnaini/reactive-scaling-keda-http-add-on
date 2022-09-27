# Install KEDA

export NAMESPACE=keda-http

```
helm repo add kedacore https://kedacore.github.io/charts
helm repo update
helm install --create-namespace -n ${NAMESPACE} keda kedacore/keda
```

# Install the KEDA Http-Add-On Operator

```
helm install --create-namespace -n ${NAMESPACE} http-add-on kedacore/keda-add-ons-http
```

# Installing and Using the ingress-nginx Ingress Controller

```
helm repo add ingress-nginx https://kubernetes.github.io/ingress-nginx
helm repo update
helm install ingress-nginx ingress-nginx/ingress-nginx -n ${NAMESPACE}
```

# Install http server

```
helm install quaruks-rest-server . -n keda-http
```

# Making an HTTP Request to your App

Run Command:

```
curl -H "Host: myhost.com" 192.168.5.15/query

or

curl -H "Host: myhost.com" keda-add-ons-http-interceptor-proxy.keda-http:8080/query

expected o/p : Hello World Quarkus Rest Server
```

# Testing via port forwarding

```
kubectl port-forward svc/ingress-nginx-controller -n ${NAMESPACE} 8080:80

or

kubectl port-forward svc/keda-add-ons-http-interceptor-proxy -n ${NAMESPACE} 8080:8080

```

<img width="1065" alt="Screenshot 2022-09-07 at 12 00 23 PM" src="https://user-images.githubusercontent.com/54102261/188805996-cc8f6833-d5b7-4caf-a79e-8e1ca801ce0d.png">



# Pods Scaling Up after increase in incoming traffic

<img width="1059" alt="Screenshot 2022-09-07 at 3 34 55 PM" src="https://user-images.githubusercontent.com/54102261/188852957-c80b20fc-c4ef-4bd9-84b5-13b9bc4b7c7a.png">

# References

https://github.com/kedacore/http-add-on/blob/main/docs/walkthrough.md