var express = require('express');
var router = express.Router();
const ProductController  = require('../controller/ProductController');
const productCtl = new ProductController();
const Validate = require('../util/validate');
const validate = new Validate();


router.get('/product', productCtl.getListProduct.bind(productCtl));
router.post('/product', productCtl.insertProduct.bind(productCtl));



router.get('/product/:id', 
    validate.userHavePermissionOnProduct.bind(validate), 
    productCtl.getListProduct.bind(productCtl));

router.put('/product/:id', 
    validate.userHavePermissionOnProduct.bind(validate),
    productCtl.updateProduct.bind(productCtl));

router.delete('/product/:id', 
    validate.userHavePermissionOnProduct.bind(validate), 
    productCtl.deleteProduct.bind(productCtl));


module.exports = router;
