# MoshiHelper
[![Build Status](https://jitpack.io/v/sanjaydraws/MoshiHelper.svg)](https://jitpack.io/v/sanjaydraws/MoshiHelper.svg)
[![Star](https://img.shields.io/github/stars/sanjaydraws/MoshiHelper.svg)](https://github.com/sanjaydraws/MoshiHelper)
<a href="https://twitter.com/sanjay_draws" target="_blank">
<img alt="Twitter: sanjay_draws" src="https://img.shields.io/twitter/follow/sanjay_draws.svg?style=social" />
</a>

## Step 1. Add the JitPack repository to your build file
Add it in your root build.gradle at the end of repositories:

```
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```

## Step 2. Add the dependency
```
dependencies
{
	        implementation 'com.github.sanjaydraws:MoshiHelper:1.0.3'
}
```

### create an instance 
```
  private val moshiHelper by lazy {
        MoshiHelper()
    }
```

### convert object to json
```
Log.d(TAG, "convertToJsonByMoshi burgerJson: ${moshiHelper.convertToJsonByMoshi(Burger(name = "Classic",price = 23,b=false))}") // {"name":"Classic","price":23,"b":false}
```

### convert json to object
```
Log.d(TAG, "convertFromJsonByMoshi burgerObj: ${moshiHelper.convertFromJsonByMoshi<Burger>("""{"name":"Classic","price":23,"b":false}""")}") //Burger(name=Classic, price=23, b=false)
```

### convert from json to list 
```
 val burgerJsonStr = """
            [{"name":"Burger Bum","price":23,"b":false},
            {"name":"Warm Buns","price":23,"b":false},{"name":"Burger Her","price":23,"b":true}]
            """
Log.d(TAG, "convertFromJsonToListByMoshi burgerObj: ${moshiHelper.convertFromJsonToListByMoshi<Burger>(burgerJsonStr)}") //[Burger(name=Burger Bum, price=23, b=false), Burger(name=Warm Buns, price=23, b=false), Burger(name=Burger Her, price=23, b=true)]
Log.d(TAG, "convertToJsonByMoshi burgerListJson: ${moshiHelper.convertToJsonByMoshi(getBurgerList())}") // "[{"name":"Bug-Her","price":93,"b":false},{"name":"Burger Bum","price":133,"b":false},{"name":"Warm Buns","price":203,"b":false}]"

```

### string  to Map
```
val burgerJsonMap = """
           {"1": {"name":"Burger Bum","price":23,"b":false},
            "2": {"name":"Warm Buns","price":23,"b":false},
            "3": {"name":"Burger Her","price":23,"b":true}
            } 
        """
Log.d(TAG, "convertFromJsonToMapByMoshi: ${moshiHelper.convertFromJsonToMapByMoshi<Int, Burger>(burgerJsonMap)}") //  {1=Burger(name=Burger Bum, price=23, b=false), 2=Burger(name=Warm Buns, price=23, b=false), 3=Burger(name=Burger Her, price=23, b=true)}
```


