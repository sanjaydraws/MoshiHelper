![](cover.jpeg)

# MoshiHelper

![buildStatus](https://img.shields.io/github/workflow/status/sanjaydraws/MoshiHelper/Publish?style=plastic)
![latestVersion](https://img.shields.io/github/v/tag/sanjaydraws/MoshiHelper)
<a href="https://twitter.com/sanjay_draws" target="_blank">
<img alt="Twitter: sanjay_draws" src="https://img.shields.io/twitter/follow/sanjay_draws.svg?style=social" />
</a>



# Implementation

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

## ✍️ Author

👤 **Sanjay Prajapat**

* Twitter: <a href="https://twitter.com/sanjay_draws" target="_blank">@sanjay_draws</a>
* Email: sprajapat8331@gmail.com

Feel free to ping me 😉

## 🤝 Contributing

Contributions are what make the open source community such an amazing place to be learn, inspire, and create. Any
contributions you make are **greatly appreciated**.

1. Open an issue first to discuss what you would like to change.
1. Fork the Project
1. Create your feature branch (`git checkout -b feature/amazing-feature`)
1. Commit your changes (`git commit -m 'Add some amazing feature'`)
1. Push to the branch (`git push origin feature/amazing-feature`)
1. Open a pull request

Please make sure to update tests as appropriate.

## ❤ Show your support

Give a ⭐️ if this project helped you!

## 📝 License

```
Copyright © 2022 - Sanjay Prajapat

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```

_This README was generated by [readgen](https://github.com/theapache64/readgen)_ ❤