const apiBaseUrl = 'http://localhost:8080';
const apiUrl = `${apiBaseUrl}/orders`;
const getProductsUrl = `${apiBaseUrl}/products`;

window.addEventListener('load', function () {
    console.log("EventListener");

    /* -------------------------------------------------------------------------- */
    /*                               View Logic                                   */
    /* -------------------------------------------------------------------------- */

    const productListLeft = document.querySelector("#productListLeft");
    const productListRight = document.querySelector("#productListRight");
    const btnAddProduct = document.querySelector("#addProduct");
    const btnRemoveProduct = document.querySelector("#removeProduct");
    const btnCreateOrder = document.querySelector("#createOrder");

    let products = [];

    fetchApiGet(getProductsUrl);

    btnAddProduct.addEventListener('click', function () {
        moveProducts(productListLeft, productListRight);
    });

    btnRemoveProduct.addEventListener('click', function () {
        moveProducts(productListRight, productListLeft);
    });

    btnCreateOrder.addEventListener('click', function (event) {
        event.preventDefault();
        generateOrders();
    });

    function moveProducts(fromList, toList) {
        const selectedProducts = fromList.querySelectorAll("input[type='checkbox']:checked");
        selectedProducts.forEach(product => {
            const parent = product.parentElement.parentElement;
            toList.appendChild(parent);
            product.checked = false;
        });
    }

    function generateOrders() {
        const selectedProducts = productListRight.querySelectorAll("input[type='checkbox']");
        if (selectedProducts.length === 0) {
            alert("There aren't products selected");
            return;
        }

        // Get last orderID and + 1
        let lastOrderId = getLastOrderId() + 1;

        selectedProducts.forEach(product => {
            const orderData = {
                id: lastOrderId,
                productId: parseInt(product.value)
            };

            fetchApiPost(apiUrl, orderData);
        });
    }

    function getLastOrderId() {
        const orderRows = document.querySelectorAll("#ordersTable tbody tr");
        if (orderRows.length === 0) return 0;

        const lastRow = orderRows[orderRows.length - 1];
        return parseInt(lastRow.cells[0].innerText);
    }

    function fetchApiPost(url, payload) {
        const configuraciones = {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
                'Access-Control-Allow-Origin': '*'
            },
            body: JSON.stringify(payload)
        };

        fetch(url, configuraciones)
            .then(respuesta => respuesta.json())
            .then(data => {
                console.log('Order created:', data);
            })
            .catch(error => console.log('Something went wrong..:', error));
    }

    function fetchApiGet(url) {
        fetch(url)
            .then(response => {
                if (!response.ok) {
                    throw new Error(`Network response was not ok. Status: ${response.status}`);
                }
                return response.json();
            })
            .then(data => {
                console.log('Data received:', data);
                products = [...data];

                products.forEach(product => {
                    const li = document.createElement('li');
                    li.innerHTML = `<label>${product.name}</label><input type="checkbox" value="${product.id}" />`;
                    productListLeft.appendChild(li);
                });
            })
            .catch(error => console.error('Something went wrong:', error));
    }
});
