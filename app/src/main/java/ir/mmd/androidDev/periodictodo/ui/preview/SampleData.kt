package ir.mmd.androidDev.periodictodo.ui.preview

import androidx.compose.runtime.mutableStateOf
import ir.mmd.androidDev.periodictodo.viewmodel.TaskViewModel
import java.util.*

val sampleTaskViewModel = TaskViewModel(
	title = "Clean Out the Garage",
	description = """
		Cleaning out the garage can be a daunting task, but it is an important part of home maintenance. Taking the time to organize and declutter your garage can help you save time, money, and energy in the long run.
		Before you start, it’s important to make sure you have the right supplies. You’ll need garbage bags, boxes, and a few tools like a broom and dustpan. You may also want to invest in a few storage containers or shelves to help you organize the items that you keep.
		Once you have the supplies, the first step is to remove all the items from the garage and sort them into piles. Discard any items that are broken, outdated, or no longer needed. You can also donate items that are still in good condition or consider selling them in a yard sale or online.
		Next, you’ll want to sweep and mop the floor to get rid of any dirt and debris. Vacuuming can help if you have carpets. After the floor is clean, you can start putting the items back in the garage.
		If you have a lot of items, it’s best to group them together by type. For example, you could store all your gardening supplies in one area and all your sporting goods in another. If possible, use storage containers or shelves to keep everything organized.
		Finally, you’ll want to take some time to maintain your garage. Make sure to sweep and mop the floor regularly and dust the shelves. You should also check for any signs of pest infestations and take steps to prevent them from occurring.
		Cleaning out the garage is a big job but it’s worth it in the end. Taking the time to organize and declutter your space will help you save time and money and keep your home in tip-top shape.
	""".trimIndent(),
	deadLine = Date(1678200535066),
	isDone = mutableStateOf(false)
)

val sampleTaskViewModelList = listOf(
	TaskViewModel(
		title = "Organize Garage",
		description = "Clean out the garage, organizing everything into sections. This includes all items on the floor, shelves, and in any storage bins. Clear out any clutter that has accumulated over time, and dispose of it properly. Group items together by type, such as sports equipment, tools, and seasonal decorations. Label the sections for easy reference. Put the items back into their designated areas, and make sure everything is neat and tidy.",
		deadLine = Date(1586509925000),
		isDone = mutableStateOf(false)
	),
	TaskViewModel(
		title = "Mow Lawn",
		description = "Mow the lawn, taking care to cut evenly across the entire area. Trim around the edges with a weed whacker or edger, ensuring that the grass is cut close to the edge of the sidewalk or driveway. Rake up any clippings and dispose of them properly. Make sure to water the lawn afterwards to help the grass stay healthy.",
		deadLine = Date(1587188345000),
		isDone = mutableStateOf(false)
	),
	TaskViewModel(
		title = "Walk Dog",
		description = "Take the dog for a walk around the neighborhood. Make sure the leash is secure, and keep an eye on the dog at all times. Bring a bag to pick up any messes, and be sure to throw it away when you get home. Take the dog to different places to explore and play, and give them plenty of love and attention while out and about.",
		deadLine = Date(1586728753000),
		isDone = mutableStateOf(true)
	),
	TaskViewModel(
		title = "Wash Car",
		description = "Wash the car inside and out. Start by giving the exterior a thorough scrub, using a sponge and car wash soap. Rinse the car off and dry it with a microfiber cloth. Vacuum the interior of the car, wiping down all surfaces with a damp cloth. Finish by cleaning the windows and mirrors with glass cleaner.",
		deadLine = Date(1586603062000),
		isDone = mutableStateOf(false)
	),
	TaskViewModel(
		title = "Grocery Shopping",
		description = "Go grocery shopping and buy the items on the list. Make sure to check the expiration dates on any food items, and read labels to compare prices and ingredients. Look for items that are on sale or have coupons available. When you are done, double check your list to make sure you have all the items you need. Don't forget to bring your reusable bags!",
		deadLine = Date(1587054684000),
		isDone = mutableStateOf(false)
	),
	TaskViewModel(
		title = "Pay Bills",
		description = "Pay all bills that are due this month. Gather all of your bills and check the due dates. Log in to your online banking account and pay each bill individually, making sure to enter the correct amounts. After you have paid each bill, make sure to write down the confirmation numbers for your records. Double check to make sure that you have paid all of the bills before the due date.",
		deadLine = Date(1586394872000),
		isDone = mutableStateOf(true)
	),
	TaskViewModel(
		title = "Clean House",
		description = "Clean the entire house from top to bottom. Start with the bedrooms, making the beds and picking up any items that don't belong. Dust and vacuum each room, and mop the floors. Move on to the bathrooms, scrubbing the toilets, sinks, and showers. Wipe down all of the surfaces and mirrors, and sweep and mop the floors. Lastly, clean the kitchen, wiping down the counters and appliances, and sweeping and mopping the floors.",
		deadLine = Date(1586968460000),
		isDone = mutableStateOf(false)
	),
	TaskViewModel(
		title = "Finish Project",
		description = "Finish the project by the end of the week. Review all of the instructions and requirements for the project, and set a timeline for completion. Break the project down into smaller tasks and assign deadlines for each one. Work diligently to complete the tasks on time, and make sure to double check your work for accuracy. Ask for help if needed, and don't be afraid to ask questions.",
		deadLine = Date(1586852759000),
		isDone = mutableStateOf(false)
	),
	TaskViewModel(
		title = "Do Laundry",
		description = "Do a load of laundry and hang it up to dry. Sort the clothes into whites, darks, and delicates. Choose the appropriate cycle and temperature settings for each load, and add the right amount of detergent. Wash the clothes and transfer them to the dryer, setting the timer for the correct amount of time. Once the cycle is complete, hang the clothes up to air dry, or put them in the dryer on the lowest heat setting.",
		deadLine = Date(1587264762000),
		isDone = mutableStateOf(false)
	),
	TaskViewModel(
		title = "Cook Dinner",
		description = "Cook a healthy dinner for the family. Choose a recipe that everyone will enjoy, and make sure to have all of the ingredients on hand. Read through the recipe carefully and prepare all of the ingredients before you start cooking. Cook the meal according to the instructions, paying close attention to the timing and temperature. Serve the meal hot and enjoy the delicious meal with your family.",
		deadLine = Date(1586481192000),
		isDone = mutableStateOf(true)
	)
)
