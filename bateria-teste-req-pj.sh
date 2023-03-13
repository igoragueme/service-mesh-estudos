while true
 do
    curl --location --request GET 'http://localhost/estudos/v1/contratos?cpf=42565867840' --header 'service-mesh: pj'
    sleep 0.5
 done
